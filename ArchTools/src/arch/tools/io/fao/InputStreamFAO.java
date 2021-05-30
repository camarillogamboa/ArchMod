package arch.tools.io.fao;

import arch.tools.object.NotReadException;
import arch.tools.object.NotUpdateException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class InputStreamFAO extends FileAccesObject<InputStream> {

    @Override
    public InputStream read(File file) throws NotReadException {
        if(!file.exists()) throw new NotReadException("El archivo \""+file.getPath()+"\" no existe.");

        try {
            return new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            throw new NotReadException(ex);
        }
    }

    @Override
    public void update(File file, InputStream inputStream) throws NotUpdateException {
        if(!file.exists()) throw new NotUpdateException("El archivo \""+file.getPath()+"\" no existe.");
    }

}
