package calculnumeric5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Gabriel Budau
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private Label label;

    @FXML
    private AnchorPane integral_tab;

    @FXML
    private AreaChart<Number, Number> integral_chart;

    @FXML
    private Button test_button;

    @FXML
    private AnchorPane integral_chart_anchor_pane;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        integral_chart = createChart();
        integral_chart_anchor_pane.getChildren().clear();
        integral_chart_anchor_pane.getChildren().add(integral_chart);
        AnchorPane.setTopAnchor(integral_chart, 0.0);
        AnchorPane.setBottomAnchor(integral_chart, 0.0);
        AnchorPane.setLeftAnchor(integral_chart, 0.0);
        AnchorPane.setRightAnchor(integral_chart, 0.0);

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    protected AreaChart<Number, Number> createChart() {
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        AreaChart<Number, Number> ac = new AreaChart<>(xAxis, yAxis);
        // setup chart
        ac.setTitle("Area Chart Example");
        xAxis.setLabel("X Axis");
        yAxis.setLabel("Y Axis");
        // add starting data
        for (int s = 0; s < 3; s++) {
            XYChart.Series<Number, Number> series = new XYChart.Series<>();
            series.setName("Data Series " + s);
            double x = 0;
            while (x < 95) {
                series.getData().add(new XYChart.Data<>(x, Math.random() * 99));
                x += 5 + (15 * Math.random());
            }
            series.getData().add(new XYChart.Data<>(99d, Math.random() * 99));
            ac.getData().add(series);
        }
        return ac;
    }

}
