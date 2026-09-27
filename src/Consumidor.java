public class Consumidor extends Thread{
    private Deposito deposito;
    private int tempo;

    // Construtor que recebe depósito e tempo de espera.
    public Consumidor(Deposito deposito, int tempo){
        this.deposito = deposito;
        this.tempo = tempo;
    }

    public void run() {

        int caixas_consumidas = 0; // Adicionando um contador para saber quantas caixas foram consumidas.

        while (caixas_consumidas < 20) {

            boolean conseguiuRetirar = deposito.retirar(); /// Sabe se há ou não caixas para consumir

            if (conseguiuRetirar == true) {
                caixas_consumidas += 1;

                System.out.println("Consumidor consumiu 1 caixa.");
                try {
                    Thread.sleep(tempo);
                } catch (InterruptedException e) {
                    System.out.println("Consumo interrompido na caixa:" + caixas_consumidas);
                }
            } else { // Se não houver, aguarda ser produzida para tentar novamente.
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    System.out.println("Tempo de espera interrompido.");
                }
            }
        }
    }
}