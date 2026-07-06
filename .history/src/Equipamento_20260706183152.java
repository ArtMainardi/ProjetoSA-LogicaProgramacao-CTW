public class Equipamento {
    private int codigo;
    private String nome;
    private String categoria;
    private String fabricante;
    private String modelo;
    private String setorInstalado;
    private String dataInstalacao;
    private String status; // ('Operando', 'Em manutenção' ou 'Inativo')

    // Construtor:
    public Equipamento(int codigo, String nome, String categoria, String fabricante, String modelo,
            String setorInstalado, String dataInstalacao, String status) {
        try {
            if(nome.length() == 0 || categoria.length() == 0 || fabricante.length() == 0 || modelo.length() == 0 || 
                setorInstalado.length() == 0 || dataInstalacao.length() == 0 || status.length() == 0){
                throw new 
            }
            this.codigo = codigo;
            this.nome = nome;
            this.categoria = categoria;
            this.fabricante = fabricante;
            this.modelo = modelo;
            this.setorInstalado = setorInstalado;
            this.dataInstalacao = dataInstalacao;
            this.status = status;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
