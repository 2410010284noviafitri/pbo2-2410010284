package id.ac.uniska.pbo2.siperpus;

import com.formdev.flatlaf.FlatLightLaf;
import id.ac.uniska.pbo2.siperpus.controller.BukuController;
import id.ac.uniska.pbo2.siperpus.dao.BukuDao;
import id.ac.uniska.pbo2.siperpus.dao.memori.BukuDaoMemori;
import id.ac.uniska.pbo2.siperpus.view.JendelaBuku;
import javax.swing.SwingUtilities;

/** Titik awal aplikasi: merakit model, view, dan controller. */
public class AplikasiBuku {

    public static void main(String[] args) {
        FlatLightLaf.setup();
        SwingUtilities.invokeLater(() -> {
            BukuDao dao = BukuDaoMemori.denganContoh();
            JendelaBuku jendela = new JendelaBuku("SiPerpus: Data Buku");
            new BukuController(dao, jendela.getBukuPanel());
            jendela.setVisible(true);
        });
    }
}