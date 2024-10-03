
package com.wdy.brobrosseur.dao.repository.base;

import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Locale;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wdy.brobrosseur.utils.*;
import com.wdy.brobrosseur.utils.dto.*;
import com.wdy.brobrosseur.utils.contract.*;
import com.wdy.brobrosseur.utils.contract.Request;
import com.wdy.brobrosseur.utils.contract.Response;
import com.wdy.brobrosseur.dao.entity.*;

/**
 * Repository customize : TypeClient.
 *
 * @author Geo
 *
 */
@Repository
public interface _TypeClientRepository {
	    /**
     * Finds TypeClient by using id as a search criteria.
     *
     * @param id
     * @return An Object TypeClient whose id is equals to the given id. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.id = :id and e.isDeleted = :isDeleted")
    TypeClient findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds TypeClient by using description as a search criteria.
     *
     * @param description
     * @return An Object TypeClient whose description is equals to the given description. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.description = :description and e.isDeleted = :isDeleted")
    List<TypeClient> findByDescription(@Param("description")String description, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using libelle as a search criteria.
     *
     * @param libelle
     * @return An Object TypeClient whose libelle is equals to the given libelle. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.libelle = :libelle and e.isDeleted = :isDeleted")
    TypeClient findByLibelle(@Param("libelle")String libelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object TypeClient whose statusId is equals to the given statusId. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<TypeClient> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object TypeClient whose updatedBy is equals to the given updatedBy. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<TypeClient> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object TypeClient whose isDeleted is equals to the given isDeleted. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.isDeleted = :isDeleted")
    List<TypeClient> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object TypeClient whose createdBy is equals to the given createdBy. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<TypeClient> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object TypeClient whose deletedAt is equals to the given deletedAt. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<TypeClient> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object TypeClient whose updatedAt is equals to the given updatedAt. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<TypeClient> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds TypeClient by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object TypeClient whose createdAt is equals to the given createdAt. If
     *         no TypeClient is found, this method returns null.
     */
    @Query("select e from TypeClient e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<TypeClient> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of TypeClient by using typeClientDto as a search criteria.
     *
     * @param request, em
     * @return A List of TypeClient
     * @throws DataAccessException,ParseException
     */
    public default List<TypeClient> getByCriteria(Request<TypeClientDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from TypeClient e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<TypeClient> query = em.createQuery(req, TypeClient.class);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        if (request.getIndex() != null && request.getSize() != null) {
            query.setFirstResult(request.getIndex() * request.getSize());
            query.setMaxResults(request.getSize());
        }
        return query.getResultList();
    }

    /**
     * Finds count of TypeClient by using typeClientDto as a search criteria.
     *
     * @param request, em
     * @return Number of TypeClient
     *
     */
    public default Long count(Request<TypeClientDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from TypeClient e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                javax.persistence.Query query = em.createQuery(req);
        for (Map.Entry<String, Object> entry : param.entrySet()) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        Long count = (Long) query.getResultList().get(0);
        return count;
    }

    /**
     * get where expression
     * @param request
     * @param param
     * @param locale
     * @return
     * @throws Exception
     */
    default String getWhereExpression(Request<TypeClientDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        TypeClientDto dto = request.getData() != null ? request.getData() : new TypeClientDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (TypeClientDto elt : request.getDatas()) {
                elt.setIsDeleted(false);
                String eltReq = generateCriteria(elt, param, index, locale);
                if (request.getIsAnd() != null && request.getIsAnd()) {
                    othersReq += "and (" + eltReq + ") ";
                } else {
                    othersReq += "or (" + eltReq + ") ";
                }
                index++;
            }
        }
        String req = "";
        if (!mainReq.isEmpty()) {
            req += " and (" + mainReq + ") ";
        }
        req += othersReq;

        //order
        if(Direction.fromOptionalString(dto.getOrderDirection()).orElse(null) != null && Utilities.notBlank(dto.getOrderField())) {
            req += " order by e."+dto.getOrderField()+" "+dto.getOrderDirection();
        }
        else {
            req += " order by  e.id desc";
        }
        return req;
    }

    /**
     * generate sql query for dto
     * @param dto
     * @param param
     * @param index
     * @param locale
     * @return
     * @throws Exception
     */
    default String generateCriteria(TypeClientDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDescription()) || Utilities.searchParamIsNotEmpty(dto.getDescriptionParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("description", dto.getDescription(), "e.description", "String", dto.getDescriptionParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLibelle()) || Utilities.searchParamIsNotEmpty(dto.getLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("libelle", dto.getLibelle(), "e.libelle", "String", dto.getLibelleParam(), param, index, locale));
            }
            if (dto.getStatusId() != null || Utilities.searchParamIsNotEmpty(dto.getStatusIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("statusId", dto.getStatusId(), "e.statusId", "Integer", dto.getStatusIdParam(), param, index, locale));
            }
            if (dto.getUpdatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getUpdatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedBy", dto.getUpdatedBy(), "e.updatedBy", "Integer", dto.getUpdatedByParam(), param, index, locale));
            }
            if (dto.getIsDeleted() != null || Utilities.searchParamIsNotEmpty(dto.getIsDeletedParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isDeleted", dto.getIsDeleted(), "e.isDeleted", "Boolean", dto.getIsDeletedParam(), param, index, locale));
            }
            if (dto.getCreatedBy() != null || Utilities.searchParamIsNotEmpty(dto.getCreatedByParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdBy", dto.getCreatedBy(), "e.createdBy", "Integer", dto.getCreatedByParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDeletedAt()) || Utilities.searchParamIsNotEmpty(dto.getDeletedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("deletedAt", dto.getDeletedAt(), "e.deletedAt", "Date", dto.getDeletedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUpdatedAt()) || Utilities.searchParamIsNotEmpty(dto.getUpdatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
