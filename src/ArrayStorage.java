/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    void clear() {
        for (int i = 0; i < storage.length; ++i) {
            storage[i] = null;
        }
    }

    void save(Resume r) {
        int resumeIndex = -1;
        for (int i = 0; i < storage.length; ++i) {
            if (storage[i] != null) {
                if (storage[i].uuid.equals(r.uuid)) {
                    break;
                }
            } else {
                resumeIndex = i;
                break;
            }
        }

        if (resumeIndex >= 0) {
            storage[resumeIndex] = r;
        }
    }

    Resume get(String uuid) {
        Resume foundResume = null;
        for (int i = 0; i < storage.length; ++i) {
            if (storage[i] == null) {
                break;
            } else if (storage[i].uuid.equals(uuid)) {
                foundResume = storage[i];
                break;
            }
        }

        return foundResume;
    }

    void delete(String uuid) {
        int delIndex = -1;

        for (int i = 0; i < storage.length; ++i) {
            if (storage[i] == null) {
                break;
            } else if (uuid.equals(storage[i].uuid)) {
                delIndex = i;
                break;
            }
        }

        if (delIndex >= 0 ) {
            for (int i = delIndex; i < storage.length - 1; ++i) {
                storage[i] = storage[i + 1];
            }

            storage[storage.length - 1] = null;
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        Resume[] resArr = new Resume[size()];

       for (int i = 0; i < resArr.length; ++i) {
           resArr[i] = storage[i];
       }
       return resArr;
    }

    int size() {
        int elemsCnt = 0;

        for (int i = 0; i < storage.length; ++i) {
            if (storage[i] != null) {
                elemsCnt++;
            } else {
                break;
            }
        }

        return elemsCnt;
    }
}
