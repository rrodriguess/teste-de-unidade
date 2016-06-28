package br.com.caelum.leilao.servico;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by renato on 28/06/16.
 */
public class Avaliador {

    private double maiorDeTodos = Double.NEGATIVE_INFINITY;
    private double menorDeTodos = Double.POSITIVE_INFINITY;
    private List<Lance> maiores;

    public double getMaiorLance() {
        return maiorDeTodos;
    }

    public double getMenorLance() {
        return menorDeTodos;
    }

    public void avalia(Leilao leilao) {

        if (leilao.getLances().size() == 0)
            throw new RuntimeException("Não é possível avaliar esse leilao");

        for (Lance lance : leilao.getLances()) {
            if (lance.getValor() > maiorDeTodos)
                maiorDeTodos = lance.getValor();
            if (lance.getValor() < menorDeTodos)
                menorDeTodos = lance.getValor();
        }

        List<Lance> tresMaiores = getTresMaiores(leilao);

    }

    public List<Lance> getTresMaiores(Leilao leilao) {
        maiores = new ArrayList<Lance>(leilao.getLances());
        Collections.sort(maiores, new Comparator<Lance>() {
            @Override
            public int compare(Lance o1, Lance o2) {
                if (o1.getValor() < o2.getValor())
                    return 1;
                if (o1.getValor() > o2.getValor())
                    return -1;

                return 0;
            }
        });
        return maiores = maiores.subList(0, maiores.size() > 3 ? 3 : maiores.size());
    }
}
