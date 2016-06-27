
 
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
/**
 * @web http://java-buddy.blogspot.com
 */
public class JavaFX_Histogram_Len extends Application {
	double[] PetalLen = new double[] { 1.4, 1.4, 1.3, 1.5, 1.4, 1.7, 1.4, 1.5, 1.4, 1.5, 1.5, 1.6, 1.4, 1.1, 1.2,
			1.5, 1.3, 1.4, 1.7, 1.5, 1.7, 1.5, 1, 1.7, 1.9, 1.6, 1.6, 1.5, 1.4, 1.6, 1.6, 1.5, 1.5, 1.4, 1.5, 1.2,
			1.3, 1.4, 1.3, 1.5, 1.3, 1.3, 1.3, 1.6, 1.9, 1.4, 1.6, 1.4, 1.5, 1.4, 4.7, 4.5, 4.9, 4, 4.6, 4.5, 4.7,
			3.3, 4.6, 3.9, 3.5, 4.2, 4, 4.7, 3.6, 4.4, 4.5, 4.1, 4.5, 3.9, 4.8, 4, 4.9, 4.7, 4.3, 4.4, 4.8, 5, 4.5,
			3.5, 3.8, 3.7, 3.9, 5.1, 4.5, 4.5, 4.7, 4.4, 4.1, 4, 4.4, 4.6, 4, 3.3, 4.2, 4.2, 4.2, 4.3, 3, 4.1, 6,
			5.1, 5.9, 5.6, 5.8, 6.6, 4.5, 6.3, 5.8, 6.1, 5.1, 5.3, 5.5, 5, 5.1, 5.3, 5.5, 6.7, 6.9, 5, 5.7, 4.9,
			6.7, 4.9, 5.7, 6, 4.8, 4.9, 5.6, 5.8, 6.1, 6.4, 5.6, 5.1, 5.6, 6.1, 5.6, 5.5, 4.8, 5.4, 5.6, 5.1, 5.1,
			5.9, 5.7, 5.2, 5, 5.2, 5.4, 5.1, };
	double[] PetalWidth = new double[] { 0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2,
			0.4, 0.4, 0.3, 0.3, 0.3, 0.2, 0.4, 0.2, 0.5, 0.2, 0.2, 0.4, 0.2, 0.2, 0.2, 0.2, 0.4, 0.1, 0.2, 0.2, 0.2,
			0.2, 0.1, 0.2, 0.2, 0.3, 0.3, 0.2, 0.6, 0.4, 0.3, 0.2, 0.2, 0.2, 0.2, 1.4, 1.5, 1.5, 1.3, 1.5, 1.3, 1.6,
			1, 1.3, 1.4, 1, 1.5, 1, 1.4, 1.3, 1.4, 1.5, 1, 1.5, 1.1, 1.8, 1.3, 1.5, 1.2, 1.3, 1.4, 1.4, 1.7, 1.5, 1,
			1.1, 1, 1.2, 1.6, 1.5, 1.6, 1.5, 1.3, 1.3, 1.3, 1.2, 1.4, 1.2, 1, 1.3, 1.2, 1.3, 1.3, 1.1, 1.3, 2.5,
			1.9, 2.1, 1.8, 2.2, 2.1, 1.7, 1.8, 1.8, 2.5, 2, 1.9, 2.1, 2, 2.4, 2.3, 1.8, 2.2, 2.3, 1.5, 2.3, 2, 2,
			1.8, 2.1, 1.8, 1.8, 1.8, 2.1, 1.6, 1.9, 2, 2.2, 1.5, 1.4, 2.3, 2.4, 1.8, 1.8, 2.1, 2.4, 2.3, 1.9, 2.3,
			2.5, 2.3, 1.9, 2, 2.3, 1.8, };

    int DATA_SIZE = 150;
    int data[] = new int[DATA_SIZE];
    int group[] = new int[10];

    @Override
    public void start(Stage primaryStage) {
         
        groupData();
    	double maxLen = 0;
    	double maxWidth = 0;
    	for (int i = 0; i < DATA_SIZE; i++) {// ｘ軸とy軸の最大値を測る
    		maxLen = Math.max(maxLen, PetalLen[i]);
    		maxWidth = Math.max(maxWidth, PetalWidth[i]);
    	}
        Label labelInfo = new Label("長さの最大値 = "+maxLen);
         
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> barChart = 
            new BarChart<>(xAxis,yAxis);
        barChart.setCategoryGap(0);
        barChart.setBarGap(0);
         
        xAxis.setLabel("大きさ");     
        yAxis.setLabel("総数");
         
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Histogram");       
        series1.getData().add(new XYChart.Data("1/10", group[0]));
        series1.getData().add(new XYChart.Data("2/10", group[1]));
        series1.getData().add(new XYChart.Data("3/10", group[2]));
        series1.getData().add(new XYChart.Data("4/10", group[3]));
        series1.getData().add(new XYChart.Data("5/10", group[4])); 
         
        series1.getData().add(new XYChart.Data("6/10", group[5]));
        series1.getData().add(new XYChart.Data("7/10", group[6]));
        series1.getData().add(new XYChart.Data("8/10", group[7]));
        series1.getData().add(new XYChart.Data("9/10", group[8]));
        series1.getData().add(new XYChart.Data("最大値以下", group[9]));
         
        barChart.getData().addAll(series1);
         
        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelInfo, barChart);
         
        StackPane root = new StackPane();
        root.getChildren().add(vBox);
         
        Scene scene = new Scene(root, 800, 450);
         
        primaryStage.setTitle("javafx Iris data");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
     
    //generate dummy random data
//    private void prepareData(){
// 
//        Random random = new Random();
//        for(int i=0; i<DATA_SIZE; i++){
//            data[i] = random.nextInt(100);
//        }
//    }
     
    //count data population in groups
    private void groupData(){
    	
        for(int i=0; i<10; i++){
            group[i]=0;
        }
    	double maxLen = 0;
    	double maxWidth = 0;
    	for (int i = 0; i < DATA_SIZE; i++) {// ｘ軸とy軸の最大値を測る
    		maxLen = Math.max(maxLen, PetalLen[i]);
    		maxWidth = Math.max(maxWidth, PetalWidth[i]);
    	}

        for(int i=0; i<DATA_SIZE; i++){
            if(PetalLen[i]<=(maxLen/10)){
                group[0]++;
            }else if(PetalLen[i]<=((maxLen*2)/10)){
                group[1]++;
            }else if(PetalLen[i]<=((maxLen*3)/10)){
                group[2]++;
            }else if(PetalLen[i]<=((maxLen*4)/10)){
                group[3]++;
            }else if(PetalLen[i]<=((maxLen*5)/10)){
                group[4]++;
            }else if(PetalLen[i]<=((maxLen*6)/10)){
                group[5]++;
            }else if(PetalLen[i]<=((maxLen*7)/10)){
                group[6]++;
            }else if(PetalLen[i]<=((maxLen*8)/10)){
                group[7]++;
            }else if(PetalLen[i]<=((maxLen*9)/10)){
                group[8]++;
            }else if(PetalLen[i]<=(maxLen)){
                group[9]++;
            }
        }
    }
     
}