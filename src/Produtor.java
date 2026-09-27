public class Produtor extends Thread{
    private Deposito deposito;
    private int tempo;

    // Construtor que recebe depósito e tempo de espera.
    public Produtor(Deposito deposito, int tempo){
        this.deposito = deposito;
        this.tempo = tempo;
    }

    public void run() {

        for (int i = 0; i < 100; i++) {
            // Inserindo itens no depósito
            deposito.colocar();

            System.out.println("Produtor fabricou 1 caixa.");
            try {
                Thread.sleep(tempo);
            } catch (InterruptedException e) {
                System.out.println("Produção interrompida na caixa:" + i);
            }
        }
    }
}
