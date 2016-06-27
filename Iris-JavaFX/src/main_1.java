import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.ScatterChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class main_1 extends Application {
	Label label1;
	Label label2;
	Label label3;

	@Override
	public void start(Stage stage) {
		stage.setTitle("Irisデータシミュレーション");

		// Petalは花びら。花びらの長さと花びらの横幅、Speciesが種類
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
		String[] Species = new String[] { "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa",
				"setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa",
				"setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa",
				"setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa",
				"setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa", "setosa",
				"setosa", "setosa", "setosa", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor", "versicolor",
				"versicolor", "versicolor", "versicolor", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica", "virginica",
				"virginica", "virginica", "virginica", "virginica", "virginica", "virginica" };
		int n = 50; // 150個

		double maxLen = 0;
		double maxWidth = 0;
		for (int i = 0; i < 50; i++) {// ｘ軸とy軸の最大値を測る
			maxLen = Math.max(maxLen, PetalLen[i]);
			maxWidth = Math.max(maxWidth, PetalWidth[i]);
		}
		// ｘ，ｙの最大値から0.1足した範囲のグラフ
		maxWidth += 0.1;
		final NumberAxis xAxis = new NumberAxis(0, maxWidth, 1);
		final NumberAxis yAxis = new NumberAxis(0, maxLen + 0.1, 1);
		final ScatterChart<Number, Number> Pane = new ScatterChart<>(xAxis, yAxis);
		Pane.setPrefSize(600, 600);

		xAxis.setLabel("花びらの横幅");
		yAxis.setLabel("花びらの長さ");
		Pane.setTitle("花びらの横幅と長さの散布図（Irisデータより）");

		XYChart.Series Species1 = new XYChart.Series();
		XYChart.Series series2 = new XYChart.Series();

		Species1.setName("ヒオウギアヤメ");
		series2.setName("回帰直線");

		// 散布図作成
		for (int i = 0; i < 50; i++) {
			switch (Species[i]) {
			case "setosa":
				Species1.getData().add(new XYChart.Data(PetalWidth[i], PetalLen[i]));
			case "versicolor":
				Species1.getData().add(new XYChart.Data(PetalWidth[i], PetalLen[i]));
			}
		}

		double a = 0, b = 0;
		double sum_xy = 0, sum_x = 0, sum_y = 0, sum_x2 = 0;
		double aveX, aveY, bunX = 0, bunY = 0, bunXY = 0;

		for (int i = 0; i < 50; i++) {
			sum_xy += PetalWidth[i] * PetalLen[i];
			sum_x += PetalWidth[i];
			sum_y += PetalLen[i];
			sum_x2 += PetalWidth[i] * PetalWidth[i];
		}

		aveX = sum_x / n;
		aveY = sum_y / n;

		for (int i = 0; i < 50; i++) {
			bunX += (PetalWidth[i] - aveX) * (PetalWidth[i] - aveX);
			bunY += (PetalLen[i] - aveY) * (PetalLen[i] - aveY);
			bunXY += (PetalWidth[i] - aveX) * (PetalLen[i] - aveY);
		}
		double r = bunXY / Math.sqrt(bunX * bunY);

		a = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x * sum_x);
		b = (sum_x2 * sum_y - sum_xy * sum_x) / (n * sum_x2 - sum_x * sum_x);
		DecimalFormat format = new DecimalFormat("0.00#");

		label1 = new Label("最小二乗法によるaとb,相関係数の解:   r = " + r + "\n" + "a = " + a + "          b = " + b);
		label2 = new Label("             ");// ただの空白
		label3 = new Label("\n" + "    y =" + format.format(a) + "x+" + format.format(b));

		Pane.getData().addAll(Species1);
		Pane.getData().addAll(series2);

		series2.getData().add(new XYChart.Data(0, b));
		series2.getData().add(new XYChart.Data(maxWidth, maxWidth * a + b));
		Scene scene = new Scene(new Group());
		final VBox vbox = new VBox();
		final HBox hbox = new HBox();
		Button viginica = new Button("viginicaのみ表示");
		Button versicolor = new Button("versicolorのみ表示");
		Button ayame = new Button("ヒオウギアヤメのみ表示");
		Button all = new Button("すべて表示");

		viginica.setOnAction((AtionEvent) -> {
			main_1 main1 = new main_1();
			main1.start(stage);
		});

		versicolor.setOnAction((AtionEvent) -> {
			main_2 main2 = new main_2();
			main2.start(stage);
		});
		ayame.setOnAction((AtionEvent) -> {
			main_3 main3 = new main_3();
			main3.start(stage);
		});
		all.setOnAction((AtionEvent) -> {
			main mainall = new main();
			mainall.start(stage);
		});
		hbox.setSpacing(10);
		hbox.getChildren().addAll(label1, label2, viginica, versicolor, ayame, all, label3);

		vbox.getChildren().addAll(Pane, hbox);
		// top余白、left余白、bottom余白、rightの余白
		// 取り敢えず10で
		hbox.setPadding(new Insets(10, 10, 10, 10));

		((Group) scene.getRoot()).getChildren().add(vbox);
		stage.setScene(scene);
		stage.show();
	}

}