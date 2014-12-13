package by.test.service.file;

import by.test.dto.File;
import by.test.dto.Folder;
import by.test.dto.TextFile;
import by.test.service.AbstractCrudService;
import by.test.util.StringUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lespons on 11.12.14.
 */

@Service
public class FileService extends AbstractCrudService<File> implements IFileService {

    private static ConcurrentHashMap<String, File> fakeDao = new ConcurrentHashMap<>();

    static {
        File folder1 = new Folder(UUID.randomUUID().toString(), "folder1", "");
        fakeDao.put(folder1.getId(), folder1);
//        child
        File folder1_1 = new Folder(UUID.randomUUID().toString(), "folder1_1", folder1.getId());
        fakeDao.put(folder1_1.getId(), folder1_1);
        File folder1_1_1 = new Folder(UUID.randomUUID().toString(), "folder1_1_1", folder1_1.getId());
        fakeDao.put(folder1_1_1.getId(), folder1_1_1);
        File folder1_1_2 = new Folder(UUID.randomUUID().toString(), "folder1_1_2", folder1_1.getId());
        fakeDao.put(folder1_1_2.getId(), folder1_1_2);
        File textFile1_1_2_1 = new TextFile(UUID.randomUUID().toString(), "textFile1_1_2_1", folder1_1_2.getId());
        ((TextFile)textFile1_1_2_1).setContent("you read textFile1_1_2_1");
        fakeDao.put(textFile1_1_2_1.getId(), textFile1_1_2_1);
        //
        File folder2 = new Folder(UUID.randomUUID().toString(), "folder2", "");
        fakeDao.put(folder2.getId(), folder2);
//        child
        File folder2_1 = new Folder(UUID.randomUUID().toString(), "folder2_1", folder2.getId());
        fakeDao.put(folder2_1.getId(), folder2_1);
        //
        File textFile1 = new TextFile(UUID.randomUUID().toString(), "textFile1", "");
        ((TextFile)textFile1).setContent("you read textFile1");
        fakeDao.put(textFile1.getId(), textFile1);
    }

    @Override
    public List<File> listByParent(String parentId) {
        List<File> files = new ArrayList<>();
        for (File f : super.list()) {
            if (StringUtils.safeString(f.getParent()).equals(parentId)) {
                files.add(f);
            }
        }
        return files;
    }

    @Override
    public List<File> listFolderByParent(String parentId) {
        List<File> files = new ArrayList<>();
        for (File f : super.list()) {
            if (StringUtils.safeString(f.getParent()).equals(parentId)
                    && f instanceof Folder
                    ) {
                files.add(f);
            }
        }
        return files;
    }

    @Override
    protected ConcurrentHashMap<String, File> getFakeDao() {
        return fakeDao;
    }

}
