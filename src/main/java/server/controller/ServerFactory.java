package server.controller;

import server.model.ServerDataModel;
import server.view.ServerMainView;

public class ServerFactory {
	public static ServerMainView serverMainView;
	public static ServerDataModel serverDataModel;
	
	public static ServerMainView getServerMainView() {
		return serverMainView;
	}
	public static void setServerMainView(ServerMainView serverMainView) {
		ServerFactory.serverMainView = serverMainView;
	}
	public static ServerDataModel getServerDataModel() {
		return serverDataModel;
	}
	public static void setServerDataModel(ServerDataModel serverDataModel) {
		ServerFactory.serverDataModel = serverDataModel;
	}
	
}
