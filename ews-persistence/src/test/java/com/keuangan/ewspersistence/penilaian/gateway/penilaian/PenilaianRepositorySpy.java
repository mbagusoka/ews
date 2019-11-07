package com.keuangan.ewspersistence.penilaian.gateway.penilaian;

import com.keuangan.ewspersistence.entity.PenilaianEntity;
import com.keuangan.ewspersistence.repository.PenilaianRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PenilaianRepositorySpy implements PenilaianRepository {

    public Optional<PenilaianEntity> penilaianOptional;
    public Page<PenilaianEntity> penilaianPage;
    public boolean penilaianByFilterWasCalled;
    public Specification specification;
    public Pageable pageable;

    @Override
    public List<PenilaianEntity> findAll() {
        return null;
    }

    @Override
    public List<PenilaianEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PenilaianEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PenilaianEntity> findAllById(Iterable<UUID> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(PenilaianEntity penilaianEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PenilaianEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PenilaianEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends PenilaianEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<PenilaianEntity> findById(UUID uuid) {
        return penilaianOptional;
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PenilaianEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<PenilaianEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PenilaianEntity getOne(UUID uuid) {
        return null;
    }

    @Override
    public <S extends PenilaianEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PenilaianEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PenilaianEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PenilaianEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PenilaianEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PenilaianEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Page<PenilaianEntity> findAll(Specification specification, Pageable pageable) {
        penilaianByFilterWasCalled = true;
        this.specification = specification;
        this.pageable = pageable;
        return penilaianPage;
    }
}
