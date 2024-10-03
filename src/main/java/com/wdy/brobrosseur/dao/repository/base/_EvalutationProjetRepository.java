
package com.wdy.brobrosseur.dao.repository.base;

import java.util.Date;
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
 * Repository customize : EvalutationProjet.
 *
 * @author Geo
 *
 */
@Repository
public interface _EvalutationProjetRepository {
	    /**
     * Finds EvalutationProjet by using id as a search criteria.
     *
     * @param id
     * @return An Object EvalutationProjet whose id is equals to the given id. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.id = :id and e.isDeleted = :isDeleted")
    EvalutationProjet findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvalutationProjet by using note as a search criteria.
     *
     * @param note
     * @return An Object EvalutationProjet whose note is equals to the given note. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.note = :note and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByNote(@Param("note")Integer note, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object EvalutationProjet whose statusId is equals to the given statusId. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object EvalutationProjet whose updatedBy is equals to the given updatedBy. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object EvalutationProjet whose isDeleted is equals to the given isDeleted. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object EvalutationProjet whose createdBy is equals to the given createdBy. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object EvalutationProjet whose deletedAt is equals to the given deletedAt. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object EvalutationProjet whose updatedAt is equals to the given updatedAt. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvalutationProjet by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object EvalutationProjet whose createdAt is equals to the given createdAt. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvalutationProjet by using projetId as a search criteria.
     *
     * @param projetId
     * @return An Object EvalutationProjet whose projetId is equals to the given projetId. If
     *         no EvalutationProjet is found, this method returns null.
     */
    @Query("select e from EvalutationProjet e where e.projet.id = :projetId and e.isDeleted = :isDeleted")
    List<EvalutationProjet> findByProjetId(@Param("projetId")Integer projetId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one EvalutationProjet by using projetId as a search criteria.
   *
   * @param projetId
   * @return An Object EvalutationProjet whose projetId is equals to the given projetId. If
   *         no EvalutationProjet is found, this method returns null.
   */
  @Query("select e from EvalutationProjet e where e.projet.id = :projetId and e.isDeleted = :isDeleted")
  EvalutationProjet findEvalutationProjetByProjetId(@Param("projetId")Integer projetId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of EvalutationProjet by using evalutationProjetDto as a search criteria.
     *
     * @param request, em
     * @return A List of EvalutationProjet
     * @throws DataAccessException,ParseException
     */
    public default List<EvalutationProjet> getByCriteria(Request<EvalutationProjetDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from EvalutationProjet e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<EvalutationProjet> query = em.createQuery(req, EvalutationProjet.class);
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
     * Finds count of EvalutationProjet by using evalutationProjetDto as a search criteria.
     *
     * @param request, em
     * @return Number of EvalutationProjet
     *
     */
    public default Long count(Request<EvalutationProjetDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from EvalutationProjet e where e IS NOT NULL";
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
    default String getWhereExpression(Request<EvalutationProjetDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        EvalutationProjetDto dto = request.getData() != null ? request.getData() : new EvalutationProjetDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (EvalutationProjetDto elt : request.getDatas()) {
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
    default String generateCriteria(EvalutationProjetDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (dto.getNote() != null || Utilities.searchParamIsNotEmpty(dto.getNoteParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("note", dto.getNote(), "e.note", "Integer", dto.getNoteParam(), param, index, locale));
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
                        if (dto.getProjetId() != null || Utilities.searchParamIsNotEmpty(dto.getProjetIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("projetId", dto.getProjetId(), "e.projet.id", "Integer", dto.getProjetIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getProjetNom()) || Utilities.searchParamIsNotEmpty(dto.getProjetNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("projetNom", dto.getProjetNom(), "e.projet.nom", "String", dto.getProjetNomParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
