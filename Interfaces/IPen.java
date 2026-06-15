package Interfaces;

import java.util.List;
import Models.Pen;

public interface IPen {
    /*
     * For adding new pen @see pen
     */
    void addPen(Pen pen); // C

    Pen getPenById(int id); // Read

    List<Pen> getAllPens(); // Read all

    void updatePen(int id, Pen Updatedpen); // Update

    void deletePen(int id); // Delete
}
