package arch.tools.io.fao;

import arch.tools.desingpattern.dao.DataAccesObject;
import arch.tools.object.NotCreationException;
import arch.tools.object.NotDeleteException;
import arch.tools.object.NotExistException;
import arch.tools.object.NotUpdateException;

import java.io.File;
import java.io.IOException;

public abstract class FileAccesObject<Data> implements DataAccesObject<File, Data> {

    @Override
    public final void create(File file, Data data) throws NotCreationException {
        try {
            existFile(file,"El archivo \"" + file.getPath() + "\" ya existe");
        } catch (NotExistException e) {
            e.printStackTrace();
        }

        try {

            if (file.createNewFile()) update(file, data);
        } catch (IOException | NotUpdateException ex) {
            throw new NotCreationException(ex);
        }
    }

    @Override
    public final void delete(File file) throws NotDeleteException {
        if(!file.delete()) throw new NotDeleteException("No fué posible eliminar el archivo: "+file.getPath());
    }

    public static void existFile(File file,String message) throws NotExistException {
        if(!file.exists()) throw new NotExistException(message);
    }

}
