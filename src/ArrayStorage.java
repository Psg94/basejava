/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    private int storageSize = 0;

    void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }

        storageSize = 0;
    }

    void save(Resume r) {
        boolean resumeFound = false;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(r.uuid)) {
                resumeFound = true;
                break;
            }
        }

        if (!resumeFound && storageSize < storage.length) {
            storage[storageSize] = r;
            storageSize++;
        }
    }

    Resume get(String uuid) {
        Resume foundResume = null;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].uuid.equals(uuid)) {
                foundResume = storage[i];
                break;
            }
        }

        return foundResume;
    }

    void delete(String uuid) {
        if (storageSize > 0) {
            int delIndex = -1;

            for (int i = 0; i < storageSize; i++) {
                if (uuid.equals(storage[i].uuid)) {
                    delIndex = i;
                    break;
                }
            }

            if (delIndex >= 0) {
                for (int i = delIndex; i < storageSize - 1; i++) {
                    storage[i] = storage[i + 1];
                }

                storage[storageSize - 1] = null;

                storageSize--;
            }
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resumes = new Resume[size()];

       for (int i = 0; i < storageSize; ++i) {
           resumes[i] = storage[i];
       }
       return resumes;
    }

    int size() {
        return storageSize;
    }
}
