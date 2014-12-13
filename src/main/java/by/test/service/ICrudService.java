package by.test.service;

import by.test.dto.IDto;

import java.util.Collection;

/**
 * Created by lespons on 11.12.14.
 */
public interface ICrudService<Dto extends IDto>  {
    Dto persist(Dto dto) throws IllegalArgumentException;
    Dto remove(Dto dto) throws IllegalArgumentException;
    Collection<Dto> list();
}
