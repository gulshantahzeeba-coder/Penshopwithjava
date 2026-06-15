package Services;

import java.util.ArrayList;
import java.util.List;

import Interfaces.IPen;
import Models.Pen;

public class PenService implements IPen {
    private List<Pen> pens = new ArrayList<>();

    @Override
    public void addPen(Pen pen) {
        // Add new pen in list
        pens.add(pen);
    }

    @Override
    public Pen getPenById(int id) {
        // gGet pen by id from in memory pens list.
        return pens.stream().filter(pen -> pen.getId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Pen> getAllPens() {
        // Get all pen list.
        return new ArrayList<>(pens);
    }

    @Override
    public void updatePen(int id, Pen updatedPen) {
        Pen pen = getPenById(id);
        if (pen != null) {
            pen.setPenTitle(updatedPen.getPenTitle());
            pen.setPenCompany(updatedPen.getPenComapny());
            pen.setPencolor(updatedPen.getPenColor());
        }
    }

    @Override
    public void deletePen(int id) {
        pens.removeIf(pen-> pen.getId() == id);
    }

}
