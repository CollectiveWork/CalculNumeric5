package calculnumeric5;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.web.WebView;

/**
 *
 * @author Gabriel Budau
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private AnchorPane integral_tab;

    @FXML
    private AreaChart<Number, Number> integral_chart;

    @FXML
    private AnchorPane integral_chart_anchor_pane;

    @FXML
    private TextArea results_textArea;

    public void calcIntegral() {
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
        calcIntegral();
    }

    protected AreaChart<Number, Number> createChart() {

        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        AreaChart<Number, Number> ac = new AreaChart<>(xAxis, yAxis);
        // setup chart

        ac.setTitle("Integral plot");
        xAxis.setLabel("X");
        yAxis.setLabel("Y");
        int tempa = -4;
        int tempb = 4;
        Integral I = new Integral(tempa, tempb);
        int n = 30;
        
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        series.setName("Integral f(x) from " + tempa + " to " + tempb  + " steps: " + n);
        
        double delta = (I.b - I.a) / n;
        for (double xi = I.a; xi < I.b; xi += delta) {
            series.getData().add(new XYChart.Data<>(xi, I.f(xi)));
            series.getData().add(new XYChart.Data<>(xi + delta, I.f(xi)));
        }
        ac.getData().add(series);
        
        XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
        series1.setName("Integral f(x) from " + tempa + " to " + tempb);
        for (double xi = I.a; xi < I.b; xi += delta) {
            series1.getData().add(new XYChart.Data<>(xi, I.f(xi)));
        }
        ac.getData().add(series1);
        
        
        String builtText = "";
        results_textArea.setText("");

        n = 10;
        builtText += "\nN = " + n + "\n";
        builtText += "Trapezului: " + Integral.trapezoid_met(I, n) + "\n";
        builtText += "Simpson   : " + Integral.simpson_met(I, n) + "\n";
        builtText += "Dreptunghi: " + Integral.rectangle_met(I, n) + "\n";
        builtText += "Newton    : " + Integral.newton_met(I, n) + "\n";
        results_textArea.setText(results_textArea.getText() + builtText);
        builtText = "";
        n = 100;
        builtText += "\nN = " + n + "\n";
        builtText += "Trapezului: " + Integral.trapezoid_met(I, n) + "\n";
        builtText += "Simpson   : " + Integral.simpson_met(I, n) + "\n";
        builtText += "Dreptunghi: " + Integral.rectangle_met(I, n) + "\n";
        builtText += "Newton    : " + Integral.newton_met(I, n) + "\n";
        results_textArea.setText(results_textArea.getText() + builtText);
        builtText = "";
        n = 1000;
        builtText += "\nN = " + n + "\n";
        builtText += "Trapezului: " + Integral.trapezoid_met(I, n) + "\n";
        builtText += "Simpson   : " + Integral.simpson_met(I, n) + "\n";
        builtText += "Dreptunghi: " + Integral.rectangle_met(I, n) + "\n";
        builtText += "Newton    : " + Integral.newton_met(I, n) + "\n";
        results_textArea.setText(results_textArea.getText() + builtText);
        return ac;
    }

}
