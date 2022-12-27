package Client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import CS.Request;
import CS.Response;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import View.Main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;


public class ClientConnection {
	public static class Connection extends Thread {
		private final Socket socket;
		private static ObjectOutputStream output;
		private final ObjectInputStream input;

		public Connection(Socket socket) throws IOException {
			this.socket = socket;
			output = new ObjectOutputStream(socket.getOutputStream());
			input = new ObjectInputStream(socket.getInputStream());

		}

		@Override
		public void run() {
			try {
				while (socket.isConnected()) {
					boolean serverHasData = socket.getInputStream().available() > 0;
					if (serverHasData) {
						Response rsp = (Response) input.readObject();
						System.out.println(Instant.now() + " Got from server: " + rsp);
						handleResponse(rsp);

					}

					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.println(Instant.now() + " Server disconnected");
			} catch (IOException | ClassNotFoundException e) {
				e.printStackTrace();
			}
		}

		public void handleResponse(Response response) throws IOException {
			System.out.println(response.getAction());
			switch (response.getAction()) {
			case "UserLoginResponse":
				UserLoginResponse(response);
				break;
			case "VizualizareCartiResponse":
				VizualizareCartiResponse(response);
				break;
			case "AdaugareAngajatResponse":
				AdaugareAngajatResponse(response);
				break;
			case "StergereAngajatResponse":
				StergereAngajatResponse(response);
				break;
			case "ActualizareAngajatResponse":
			    ActualizareAngajatResponse(response);
				break;
			case "AdaugareCarteResponse":
				AdaugareCarteResponse(response);
				break;
			case "StergereCarteResponse":
				StergereCarteResponse(response);
				break;
			case "ActualizareCarteResponse":
				ActualizareCarteResponse(response);
				break;
			case "CautareCarteResponse":
				CautaCarteResponse(response);
				break;
			case "VanzareCarteResponse":
				VanzareCarteResponse(response);
				break;
			case "VizualizareAngajatiResponse":
				VizualizareAngajatiResponse(response);
				break;
			case "FiltrareCarteResponse":
				FiltrareCarteResponse(response);
				break;
			case "RapoarteResponse":
				RapoarteResponse(response);
			case "AfisareLibrarieResponse":
				AfisareLibrarieResponse(response);
		
			}

		}

		private void UserLoginResponse(Response responseData) throws IOException {
			// Main main = new Main();
			System.out.println("da");
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("LOGIN FAILED");
			}
		}

		private void VizualizareCartiResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}
		
		private void AfisareLibrarieResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void AdaugareAngajatResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void StergereAngajatResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void ActualizareAngajatResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void AdaugareCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void ActualizareCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void StergereCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

		private void CautaCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}
		private void VanzareCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

	
		private void VizualizareAngajatiResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}

	

		private void FiltrareCarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}
		
		private void RapoarteResponse(Response responseData) throws IOException {
			// Main main = new Main();
			if (responseData.getStatus().equals("success")) {
				System.out.println("SUCCES");
			} else {
				System.out.println("FAILED");
			}
		}
	

		public static void sendMessageToServer(Request request) throws IOException {
			output.writeObject(request);
		}

	}

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Connection connection = null;
		try {
			connection = new Connection(new Socket("localhost", 3001));
			connection.start();
			Main.main(args);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}