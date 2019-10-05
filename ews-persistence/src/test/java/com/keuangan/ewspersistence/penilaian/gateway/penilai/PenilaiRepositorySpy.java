package com.keuangan.ewspersistence.penilaian.gateway.penilai;

import com.keuangan.ewspersistence.entity.PenilaiEntity;
import com.keuangan.ewspersistence.repository.PenilaiRepository;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class PenilaiRepositorySpy implements PenilaiRepository {

    public Optional<PenilaiEntity> penilaiOptional;
    public Page<PenilaiEntity> penilaiPage;
    public boolean penilaiByFilterWasCalled;
    public Specification specification;
    public Pageable pageable;

    @Override
    public List<PenilaiEntity> findAll() {
        return null;
    }

    @Override
    public List<PenilaiEntity> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<PenilaiEntity> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<PenilaiEntity> findAllById(Iterable<UUID> iterable) {
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
    public void delete(PenilaiEntity penilaiEntity) {

    }

    @Override
    public void deleteAll(Iterable<? extends PenilaiEntity> iterable) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends PenilaiEntity> S save(S s) {
        return null;
    }

    @Override
    public <S extends PenilaiEntity> List<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<PenilaiEntity> findById(UUID uuid) {
        return penilaiOptional;
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends PenilaiEntity> S saveAndFlush(S s) {
        return null;
    }

    @Override
    public void deleteInBatch(Iterable<PenilaiEntity> iterable) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public PenilaiEntity getOne(UUID uuid) {
        return null;
    }

    @Override
    public <S extends PenilaiEntity> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends PenilaiEntity> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends PenilaiEntity> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends PenilaiEntity> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends PenilaiEntity> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends PenilaiEntity> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public Page<PenilaiEntity> findAll(Specification<PenilaiEntity> specification, Pageable pageable) {
        penilaiByFilterWasCalled = true;
        this.specification = specification;
        this.pageable = pageable;
        return penilaiPage;
    }
}
