package by.test.service.file;

import by.test.dto.File;
import by.test.service.ICrudService;

import java.util.List;

/**
 * Created by lespons on 11.12.14.
 */
public interface IFileService extends ICrudService<File> {
    List<File> listByParent(String parentId);
    List<File> listFolderByParent(String parentId);
}
