package by.test.service;

import by.test.dto.AbstractDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lespons on 11.12.14.
 */
public abstract class AbstractCrudService<Dto extends AbstractDto> {
    protected abstract ConcurrentHashMap<String, Dto> getFakeDao();

    public Dto persist(Dto dto) throws IllegalArgumentException {
        if (dto == null) {
            throw new IllegalArgumentException("Dto is null");
        }
        if (dto.getId() == null) {
            dto.setId(UUID.randomUUID().toString());
        }
        return getFakeDao().put(dto.getId(), dto);
    }

    public Dto remove(Dto dto) throws IllegalArgumentException {
        if (dto == null) {
            throw new IllegalArgumentException("Dto is null");
        }
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Dto identity is null");
        }
        return getFakeDao().remove(dto.getId());
    }

    public Dto find(String id) throws IllegalArgumentException {
        if (id == null) {
            throw new IllegalArgumentException("Dto identity is null");
        }
        return getFakeDao().get(id);
    }

    public List<Dto> list() {
        return Collections.unmodifiableList(new ArrayList(getFakeDao().values()));
    }
}
