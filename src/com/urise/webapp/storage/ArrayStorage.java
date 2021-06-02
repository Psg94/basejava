package com.urise.webapp.storage;

import com.urise.webapp.model.Resume;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {

    Resume[] storage = new Resume[10000];

    private int storageSize = 0;

    private int getResumeIndex(String uuid) {
        int resumeIndex = -1;

        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resumeIndex = i;
                break;
            }
        }

        return resumeIndex;
    }

    public void clear() {
        for (int i = 0; i < storageSize; i++) {
            storage[i] = null;
        }

        storageSize = 0;
    }

    public void save(Resume r) {
        boolean resumeFound = (getResumeIndex(r.getUuid()) >= 0);

        if (resumeFound) {
            System.out.println("Error: resume already exists!");
        } else if (storageSize == storage.length) {
            System.out.println("Error: not enough space for new resume!");
        } else {
            storage[storageSize] = r;
            storageSize++;
        }
    }

    public void update(Resume r) {
        int resumeIndex = getResumeIndex(r.getUuid());

        if (resumeIndex >= 0) {
            storage[resumeIndex] = r;
        } else {
            System.out.println("Error: resume doesn't exists!");
        }
    }

    public Resume get(String uuid) {
        Resume resume = null;
        for (int i = 0; i < storageSize; i++) {
            if (storage[i].getUuid().equals(uuid)) {
                resume = storage[i];
                break;
            }
        }

        return resume;
    }

    public void delete(String uuid) {
        int resumeIndex = getResumeIndex(uuid);

        if (resumeIndex >= 0) {
            storage[resumeIndex] = storage[storageSize - 1];
            storage[storageSize - 1] = null;
            storageSize--;
        } else {
            System.out.println("Error: resume with uuid = " + uuid + " wasn't found!");
        }
    }

    /**
     * @return array, contains only Resumes in storage (without null)
     */
    public Resume[] getAll() {
        Resume[] resumes = new Resume[size()];

       for (int i = 0; i < storageSize; ++i) {
           resumes[i] = storage[i];
       }
       return resumes;
    }

    public int size() {
        return storageSize;
    }
}
