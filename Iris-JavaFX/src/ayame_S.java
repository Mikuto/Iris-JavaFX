 
import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
 
/**
 *
 * @author bitwalk
 */
public class ayame_S extends Application {
 
    @Override
    public void start(Stage stage) {
		stage.setTitle("Irisデータシミュレーション");
		double[] PetalLen = new double[] {1.4, 1.4, 1.3, 1.5, 1.4, 1.7, 1.4, 1.5, 1.4, 1.5, 1.5, 1.6, 1.4, 1.1, 1.2, 1.5, 1.3, 1.4, 1.7, 1.5, 1.7, 1.5, 1, 1.7, 1.9, 1.6, 1.6, 1.5, 1.4, 1.6, 1.6, 1.5, 1.5, 1.4, 1.5, 1.2, 1.3, 1.4, 1.3, 1.5, 1.3, 1.3, 1.3, 1.6, 1.9, 1.4, 1.6, 1.4, 1.5, 1.4};
		double[] PetalWidth = new double[] {0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2, 0.4, 0.4, 0.3, 0.3, 0.3, 0.2, 0.4, 0.2, 0.5, 0.2, 0.2, 0.4, 0.2, 0.2, 0.2, 0.2, 0.4, 0.1, 0.2, 0.2, 0.2, 0.2, 0.1, 0.2, 0.2, 0.3, 0.3, 0.2, 0.6, 0.4, 0.3, 0.2, 0.2, 0.2, 0.2};
		int n = PetalLen.length; // 150個

		double maxLen = 0;
		double maxWidth = 0;
		for (int i = 0; i < n; i++) {// ｘ軸とy軸の最大値を測る
			maxLen = Math.max(maxLen, PetalLen[i]);
			maxWidth = Math.max(maxWidth, PetalWidth[i]);
		}
		// ｘ，ｙの最大値から0.1足した範囲のグラフ
		maxWidth += 2;
		final NumberAxis xAxis = new NumberAxis(0, maxWidth, 1);
		final NumberAxis yAxis = new NumberAxis(0, maxLen + 3, 1);
		final ScatterChart<Number, Number> Pane = new ScatterChart<>(xAxis, yAxis);
		Pane.setPrefSize(600, 600);

		xAxis.setLabel("花びらの横幅");
		yAxis.setLabel("花びらの長さ");
		Pane.setTitle("花びらの横幅と長さの散布図（Irisデータより）");
 
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("ヒオウギアヤメ");
 
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("ヒオウギアヤメデータ");
		for (int i = 0; i < n; i++) {
			series1.getData().add(new XYChart.Data(PetalWidth[i], PetalLen[i]));
		}
		double a = 0, b = 0;
		double sum_xy = 0, sum_x = 0, sum_y = 0, sum_x2 = 0;
		double aveX, aveY, bunX = 0, bunY = 0, bunXY = 0;

		for (int i = 0; i < n; i++) {
			sum_xy += PetalWidth[i] * PetalLen[i];
			sum_x += PetalWidth[i];
			sum_y += PetalLen[i];
			sum_x2 += PetalWidth[i] * PetalWidth[i];
		}

		aveX = sum_x / n;
		aveY = sum_y / n;

		for (int i = 0; i < n; i++) {
			bunX += (PetalWidth[i] - aveX) * (PetalWidth[i] - aveX);
			bunY += (PetalLen[i] - aveY) * (PetalLen[i] - aveY);
			bunXY += (PetalWidth[i] - aveX) * (PetalLen[i] - aveY);
		}
		double r = bunXY / Math.sqrt(bunX * bunY);

		a = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x);
		b = (sum_x2 * sum_y - sum_xy * sum_x) / (n * sum_x2 - sum_x * sum_x);
		DecimalFormat format = new DecimalFormat("0.00#");

		Label label1 = new Label("最小二乗法によるaとb,相関係数の解:   r = " + r + "\n" + "a = " + a + "          b = " + b);
		Label label2 = new Label("             ");// ただの空白
		Label label3 = new Label("\n" + "    y =" + format.format(a) + "x+" + format.format(b));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("回帰直線");
        series2.getData().add(new XYChart.Data(0, b));
        series2.getData().add(new XYChart.Data(maxWidth, maxWidth * a + b));
 
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(true);
 
        lineChart.getData().addAll(series1, series2);
 
        Scene scene = new Scene(lineChart, 600, 400);
        scene.getStylesheets().add(getClass().getResource("XYChart.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
 
}