package client.view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

public class ExpressiveView extends JPanel {

	public ExpressiveView(ExpressiveFaceView expressiveFaceView, ExpressiveGraphView expressiveGraphView) {
		setLayout(new BorderLayout());
		/*ClientDataSingleton.getInstance().setExpressplot(expressionPlots);
		ClientDataSingleton.getInstance().setFaceExpressions(faceExpressions);*/
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setResizeWeight(0.3);
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		splitPane.add(expressiveFaceView);
		splitPane.add(expressiveGraphView);
		add(splitPane, BorderLayout.CENTER);
	}

}
