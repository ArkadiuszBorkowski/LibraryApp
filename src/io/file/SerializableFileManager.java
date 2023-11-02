package io.file;

import exception.DataExportException;
import exception.DataImportException;
import model.Library;

import java.io.*;

class SerializableFileManager implements FileManager {
    private static final String FILE_NAME = "Library.o";

    @Override
    public Library importData() {

        try (
            FileInputStream fis = new FileInputStream(FILE_NAME);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ){
            return (Library) ois.readObject();
        } catch(FileNotFoundException e){
            throw new DataImportException("Brak pliku " + FILE_NAME);
        } catch(IOException e){
            throw new DataImportException("Brak odczytu z pliku " + FILE_NAME);
        } catch(ClassNotFoundException e){
            throw new DataImportException("Niezgodny typ danych w pliku " + FILE_NAME);
        }


    }

    @Override
    public void exportData(Library library) {
        try (
            FileOutputStream fos = new FileOutputStream(FILE_NAME);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(library);
        } catch (FileNotFoundException e) {
            throw new DataExportException("Brak pliku " + FILE_NAME);
        } catch (IOException e) {
            throw new DataExportException("Błąd zapisu danych do pliku " + FILE_NAME);
        }

    }
}
