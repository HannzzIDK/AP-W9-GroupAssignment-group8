package henshin;

import java.util.ArrayList;
import java.util.List;

public class medalRepository<T extends coreMedal> {

    private List<T> storage;

    public medalRepository() {
        this.storage = new ArrayList<>();
    }

    public void addMedal(T medal) {
        storage.add(medal);
    }

    public List<T> getAllMedals() {
        return storage;
    }

    public T getMedalByIndex(int index) {
        if (index < 0 || index >= storage.size()) {
            throw new IndexOutOfBoundsException("Error: Invalid medal selection! Index is out of bounds.");
        }
        return storage.get(index);
    }

    public int getSize() {
        return storage.size();
    }
}
