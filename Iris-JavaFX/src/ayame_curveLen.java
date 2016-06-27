import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class ayame_curveLen extends Application {

    @Override public void start(Stage stage) {
        stage.setTitle("曲線モデルシミュレーション");
		String[] x = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50"};
		double[] setosaLen = new double[] {1.4,1.4,1.3,1.5,1.4,1.7,1.4,1.5,1.4,1.5,1.5,1.6,1.4,1.1,1.2,1.5,1.3,1.4,1.7,1.5,1.7,1.5,1,1.7,1.9,1.6,1.6,1.5,1.4,1.6,1.6,1.5,1.5,1.4,1.5,1.2,1.3,1.4,1.3,1.5,1.3,1.3,1.3,1.6,1.9,1.4,1.6,1.4,1.5,1.4};
		double[] setosaWidth = new double[] {0.2,0.2,0.2,0.2,0.2,0.4,0.3,0.2,0.2,0.1,0.2,0.2,0.1,0.1,0.2,0.4,0.4,0.3,0.3,0.3,0.2,0.4,0.2,0.5,0.2,0.2,0.4,0.2,0.2,0.2,0.2,0.4,0.1,0.2,0.2,0.2,0.2,0.1,0.2,0.2,0.3,0.3,0.2,0.6,0.4,0.3,0.2,0.2,0.2,0.2};
		double[] versicolorLen = new double[] {4.7,4.5,4.9,4,4.6,4.5,4.7,3.3,4.6,3.9,3.5,4.2,4,4.7,3.6,4.4,4.5,4.1,4.5,3.9,4.8,4,4.9,4.7,4.3,4.4,4.8,5,4.5,3.5,3.8,3.7,3.9,5.1,4.5,4.5,4.7,4.4,4.1,4,4.4,4.6,4,3.3,4.2,4.2,4.2,4.3,3,4.1};
		double[] versicolorWidth = new double[] {1.4,1.5,1.5,1.3,1.5,1.3,1.6,1,1.3,1.4,1,1.5,1,1.4,1.3,1.4,1.5,1,1.5,1.1,1.8,1.3,1.5,1.2,1.3,1.4,1.4,1.7,1.5,1,1.1,1,1.2,1.6,1.5,1.6,1.5,1.3,1.3,1.3,1.2,1.4,1.2,1,1.3,1.2,1.3,1.3,1.1,1.3};
		double[] virginicaLen = new double[] {6,5.1,5.9,5.6,5.8,6.6,4.5,6.3,5.8,6.1,5.1,5.3,5.5,5,5.1,5.3,5.5,6.7,6.9,5,5.7,4.9,6.7,4.9,5.7,6,4.8,4.9,5.6,5.8,6.1,6.4,5.6,5.1,5.6,6.1,5.6,5.5,4.8,5.4,5.6,5.1,5.1,5.9,5.7,5.2,5,5.2,5.4,5.1};
		double[] virginicaWidth = new double[] {2.5,1.9,2.1,1.8,2.2,2.1,1.7,1.8,1.8,2.5,2,1.9,2.1,2,2.4,2.3,1.8,2.2,2.3,1.5,2.3,2,2,1.8,2.1,1.8,1.8,1.8,2.1,1.6,1.9,2,2.2,1.5,1.4,2.3,2.4,1.8,1.8,2.1,2.4,2.3,1.9,2.3,2.5,2.3,1.9,2,2.3,1.8};
		int n = setosaLen.length; // 150個
		double maxLen = 0;
		double maxWidth = 0;
		for (int i = 0; i < n; i++) {// ｘ軸とy軸の最大値を測る
			maxLen = Math.max(maxLen, setosaLen[i]);
			maxWidth = Math.max(maxWidth, setosaWidth[i]);
		}
	    final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
         xAxis.setLabel("横幅");
        final LineChart<String,Number> lineChart =
                new LineChart<String,Number>(xAxis,yAxis);

        lineChart.setTitle("ヒオウギアヤメ Len");
    	final ScatterChart<String, Number> Pane = new ScatterChart<>(xAxis, yAxis);

        Pane.setPrefSize(600, 600);

		xAxis.setLabel("花びらの横幅");
		yAxis.setLabel("花びらの長さ");
		Pane.setTitle("花びらの横幅と長さの散布図（Irisデータより）");


        XYChart.Series series1 = new XYChart.Series();
        series1.setName("花びらのデータ");
        	for(int i = 0; i < x.length; i++){
    		series1.getData().add(new XYChart.Data(x[i], setosaLen[i]));
   			}

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("ゴンペルツ曲線モデル");
        double ap = 21.16490295;
		double bp = 2.655615712;
		double cp = 1.002161519;
		double y;
		for (int i = 0; i < x.length; i++) {
		y = ap*Math.exp((-bp*Math.pow(cp,i+1)));
		series2.getData().add(new XYChart.Data(x[i],y));
		}

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("ロジスティク曲線モデル");
        double ar =	14.69275029;
        double br =	9.139325895;
   		double cr =	0.000385744;

        double yr;
			for (int i = 0; i < x.length; i++) {
				y = ar/(1+br*Math.exp((-cr*(i+1))));
				series3.getData().add(new XYChart.Data(x[i],y));
			}
		XYChart.Series series4 = new XYChart.Series();
	    series4.setName("最小二乗法による解");

		Scene scene = new Scene(new Group());
		final VBox vbox = new VBox();
		final HBox hbox = new HBox();
//		Button gomperz = new Button("ゴンペルツ曲線モデルのみ表示");
//		Button logistic = new Button("ロジスティク曲線モデルのみ表示");
//		Button saijou = new Button("最小二乗法による解のみ表示");
//		Button all = new Button("すべて表示");
//		gomperz.setOnAction((ActionEvent)-> {
//			main_1 main1 = new main_1();
//			main1.start(stage);
//		});
//		logistic.setOnAction((ActionEvent)-> {
//			main_2 main2 = new main_2();
//			main2.start(stage);
//		});
//		saijou.setOnAction((ActionEvent)-> {
//			main_3 main3 = new main_3();
//			main3.start(stage);
//		});
//		all.setOnAction((ActionEvent)-> {
//			main_all mainall = new main_all();
//			mainall.start(stage);
//		});
//		hbox.setSpacing(10);
//		hbox.getChildren().addAll(gomperz, logistic, saijou, all);


        lineChart.getData().addAll(series2, series3,series1);

		vbox.getChildren().addAll(lineChart,hbox);
		hbox.setPadding(new Insets(-80, 0, 0, 0));

		((Group) scene.getRoot()).getChildren().add(vbox);
        stage.setScene(scene);
        stage.show();
    }
	public static void main(String[] args) {
		launch(args);
	}
}