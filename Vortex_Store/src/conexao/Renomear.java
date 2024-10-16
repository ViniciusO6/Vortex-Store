package conexao;

import java.io.File;
import java.util.UUID;

/**
 *
 * @author vinic
 */
public class Renomear {
    
    public static String salvarArquivoComNomeOriginal(String caminhoAntigo) {
        File arquivoAntigo = new File(caminhoAntigo);

        // Pega o nome original do arquivo
        String nomeOriginal = arquivoAntigo.getName();

        // Extrai o diretório do arquivo antigo
        String diretorio = arquivoAntigo.getParent();

        // Gera um novo nome aleatório
        String novoNome = UUID.randomUUID().toString();

        // Extrai a extensão do arquivo original
        String extensao = "";
        int indiceUltimoPonto = nomeOriginal.lastIndexOf('.');
        if (indiceUltimoPonto > 0 && indiceUltimoPonto < nomeOriginal.length() - 1) {
            extensao = nomeOriginal.substring(indiceUltimoPonto);
        }

        // Cria um novo arquivo com o novo nome e a mesma extensão
        File arquivoNovo = new File(diretorio + File.separator + novoNome + extensao);

        try {
            // Renomeia o arquivo original para o novo nome
            boolean sucessoRenomeacao = arquivoAntigo.renameTo(arquivoNovo);

            if (sucessoRenomeacao) {
                System.out.println("Arquivo renomeado com sucesso para: " + arquivoNovo.getPath());

                // Armazena o caminho do novo arquivo no banco de dados
                String caminhoParaSalvarNoBanco = arquivoNovo.getPath();
                System.out.println("Nome original: " + nomeOriginal);
                System.out.println("Caminho salvo no banco de dados: " + caminhoParaSalvarNoBanco);

                // Renomeia o arquivo para o nome original
                File arquivoOriginal = new File(diretorio + File.separator + nomeOriginal);
                boolean sucessoFinal = arquivoNovo.renameTo(arquivoOriginal);


                // Retorna o novo nome
                return novoNome + extensao;
            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro: " + e.getMessage());
        }
        return null; // Retorna null em caso de falha
    }

    public static void main(String[] args) {
        // Exemplo de uso
        String caminhoOriginal = "C:\\Users\\vinic\\Downloads\\roblox.png";
        String novoNome = salvarArquivoComNomeOriginal(caminhoOriginal);
        
        if (novoNome != null) {
            System.out.println("Novo nome do arquivo: " + novoNome);
        } else {
            System.out.println("Ocorreu um erro ao renomear o arquivo.");
        }
    }
}
