package conexao;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject; // Certifique-se de adicionar a biblioteca JSON

public class Upload {
    public static String nomeFile;
    
    public Upload(String onde, String arquivo) {
        
        String url = onde;
        String filePath = arquivo;
        String boundary = "===" + System.currentTimeMillis() + "==="; // Boundary para multipart

        try {
            // Abrindo a conexão
            URL serverUrl = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) serverUrl.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + boundary);

            // Criando a parte do conteúdo do arquivo
            OutputStream outputStream = connection.getOutputStream();
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream, "UTF-8"), true);

            // Iniciando a parte de upload do arquivo
            writer.append("--").append(boundary).append("\r\n");
            writer.append("Content-Disposition: form-data; name=\"file\"; filename=\"" + new File(filePath).getName() + "\"\r\n");
            writer.append("Content-Type: application/octet-stream\r\n\r\n");
            writer.flush();

            // Enviando o arquivo
            FileInputStream inputStream = new FileInputStream(new File(filePath));
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.flush();
            inputStream.close();

            // Finalizando a parte do arquivo
            writer.append("\r\n").flush();
            writer.append("--").append(boundary).append("--").append("\r\n");
            writer.close();

            // Verificando a resposta do servidor
            int responseCode = connection.getResponseCode();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            System.out.println("Resposta do servidor: " + response.toString()); // Adicionada para depuração
            reader.close();

            // Analisando a resposta JSON do servidor
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.getString("status").equals("success")) {
                nomeFile = jsonResponse.getString("filename");
                System.out.println("Arquivo enviado com sucesso: " + nomeFile);
            } else {
                System.out.println("Erro: " + jsonResponse.getString("message"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }   
}