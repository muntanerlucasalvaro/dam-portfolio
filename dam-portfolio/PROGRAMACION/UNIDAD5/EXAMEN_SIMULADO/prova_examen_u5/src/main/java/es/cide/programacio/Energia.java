package es.cide.programacio;

import java.util.Random;

public interface Energia {
    Random ra = new Random();

    public void carregarBateria();

    public boolean teCorrent();
}
