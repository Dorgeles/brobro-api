
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
 * Repository customize : EvaluationPrestation.
 *
 * @author Geo
 *
 */
@Repository
public interface _EvaluationPrestationRepository {
	    /**
     * Finds EvaluationPrestation by using id as a search criteria.
     *
     * @param id
     * @return An Object EvaluationPrestation whose id is equals to the given id. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.id = :id and e.isDeleted = :isDeleted")
    EvaluationPrestation findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvaluationPrestation by using note as a search criteria.
     *
     * @param note
     * @return An Object EvaluationPrestation whose note is equals to the given note. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.note = :note and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByNote(@Param("note")Integer note, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using commentaire as a search criteria.
     *
     * @param commentaire
     * @return An Object EvaluationPrestation whose commentaire is equals to the given commentaire. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.commentaire = :commentaire and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByCommentaire(@Param("commentaire")String commentaire, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object EvaluationPrestation whose statusId is equals to the given statusId. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object EvaluationPrestation whose updatedBy is equals to the given updatedBy. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object EvaluationPrestation whose isDeleted is equals to the given isDeleted. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object EvaluationPrestation whose createdBy is equals to the given createdBy. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object EvaluationPrestation whose deletedAt is equals to the given deletedAt. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object EvaluationPrestation whose updatedAt is equals to the given updatedAt. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationPrestation by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object EvaluationPrestation whose createdAt is equals to the given createdAt. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvaluationPrestation by using commandeId as a search criteria.
     *
     * @param commandeId
     * @return An Object EvaluationPrestation whose commandeId is equals to the given commandeId. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.command.id = :commandeId and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByCommandeId(@Param("commandeId")Integer commandeId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one EvaluationPrestation by using commandeId as a search criteria.
   *
   * @param commandeId
   * @return An Object EvaluationPrestation whose commandeId is equals to the given commandeId. If
   *         no EvaluationPrestation is found, this method returns null.
   */
  @Query("select e from EvaluationPrestation e where e.command.id = :commandeId and e.isDeleted = :isDeleted")
  EvaluationPrestation findEvaluationPrestationByCommandeId(@Param("commandeId")Integer commandeId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds EvaluationPrestation by using prestationId as a search criteria.
     *
     * @param prestationId
     * @return An Object EvaluationPrestation whose prestationId is equals to the given prestationId. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.prestation.id = :prestationId and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByPrestationId(@Param("prestationId")Integer prestationId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one EvaluationPrestation by using prestationId as a search criteria.
   *
   * @param prestationId
   * @return An Object EvaluationPrestation whose prestationId is equals to the given prestationId. If
   *         no EvaluationPrestation is found, this method returns null.
   */
  @Query("select e from EvaluationPrestation e where e.prestation.id = :prestationId and e.isDeleted = :isDeleted")
  EvaluationPrestation findEvaluationPrestationByPrestationId(@Param("prestationId")Integer prestationId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds EvaluationPrestation by using customerId as a search criteria.
     *
     * @param customerId
     * @return An Object EvaluationPrestation whose customerId is equals to the given customerId. If
     *         no EvaluationPrestation is found, this method returns null.
     */
    @Query("select e from EvaluationPrestation e where e.customer.id = :customerId and e.isDeleted = :isDeleted")
    List<EvaluationPrestation> findByCustomerId(@Param("customerId")Integer customerId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one EvaluationPrestation by using customerId as a search criteria.
   *
   * @param customerId
   * @return An Object EvaluationPrestation whose customerId is equals to the given customerId. If
   *         no EvaluationPrestation is found, this method returns null.
   */
  @Query("select e from EvaluationPrestation e where e.customer.id = :customerId and e.isDeleted = :isDeleted")
  EvaluationPrestation findEvaluationPrestationByCustomerId(@Param("customerId")Integer customerId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of EvaluationPrestation by using evaluationPrestationDto as a search criteria.
     *
     * @param request, em
     * @return A List of EvaluationPrestation
     * @throws DataAccessException,ParseException
     */
    public default List<EvaluationPrestation> getByCriteria(Request<EvaluationPrestationDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from EvaluationPrestation e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<EvaluationPrestation> query = em.createQuery(req, EvaluationPrestation.class);
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
     * Finds count of EvaluationPrestation by using evaluationPrestationDto as a search criteria.
     *
     * @param request, em
     * @return Number of EvaluationPrestation
     *
     */
    public default Long count(Request<EvaluationPrestationDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from EvaluationPrestation e where e IS NOT NULL";
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
    default String getWhereExpression(Request<EvaluationPrestationDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        EvaluationPrestationDto dto = request.getData() != null ? request.getData() : new EvaluationPrestationDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (EvaluationPrestationDto elt : request.getDatas()) {
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
    default String generateCriteria(EvaluationPrestationDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (dto.getNote() != null || Utilities.searchParamIsNotEmpty(dto.getNoteParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("note", dto.getNote(), "e.note", "Integer", dto.getNoteParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCommentaire()) || Utilities.searchParamIsNotEmpty(dto.getCommentaireParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("commentaire", dto.getCommentaire(), "e.commentaire", "String", dto.getCommentaireParam(), param, index, locale));
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
                        if (dto.getCommandeId() != null || Utilities.searchParamIsNotEmpty(dto.getCommandeIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("commandeId", dto.getCommandeId(), "e.command.id", "Integer", dto.getCommandeIdParam(), param, index, locale));
            }
                        if (dto.getPrestationId() != null || Utilities.searchParamIsNotEmpty(dto.getPrestationIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prestationId", dto.getPrestationId(), "e.prestation.id", "Integer", dto.getPrestationIdParam(), param, index, locale));
            }
                        if (dto.getCustomerId() != null || Utilities.searchParamIsNotEmpty(dto.getCustomerIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("customerId", dto.getCustomerId(), "e.customer.id", "Integer", dto.getCustomerIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrestationLibelle()) || Utilities.searchParamIsNotEmpty(dto.getPrestationLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prestationLibelle", dto.getPrestationLibelle(), "e.prestation.libelle", "String", dto.getPrestationLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
