
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
 * Repository customize : EvaluationCommand.
 *
 * @author Geo
 *
 */
@Repository
public interface _EvaluationCommandRepository {
	    /**
     * Finds EvaluationCommand by using id as a search criteria.
     *
     * @param id
     * @return An Object EvaluationCommand whose id is equals to the given id. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.id = :id and e.isDeleted = :isDeleted")
    EvaluationCommand findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvaluationCommand by using noteRapidite as a search criteria.
     *
     * @param noteRapidite
     * @return An Object EvaluationCommand whose noteRapidite is equals to the given noteRapidite. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.noteRapidite = :noteRapidite and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByNoteRapidite(@Param("noteRapidite")Integer noteRapidite, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using notePrestation as a search criteria.
     *
     * @param notePrestation
     * @return An Object EvaluationCommand whose notePrestation is equals to the given notePrestation. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.notePrestation = :notePrestation and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByNotePrestation(@Param("notePrestation")Integer notePrestation, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using noteConservation as a search criteria.
     *
     * @param noteConservation
     * @return An Object EvaluationCommand whose noteConservation is equals to the given noteConservation. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.noteConservation = :noteConservation and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByNoteConservation(@Param("noteConservation")Integer noteConservation, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using commentairePrestation as a search criteria.
     *
     * @param commentairePrestation
     * @return An Object EvaluationCommand whose commentairePrestation is equals to the given commentairePrestation. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.commentairePrestation = :commentairePrestation and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByCommentairePrestation(@Param("commentairePrestation")String commentairePrestation, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using dateEvaluation as a search criteria.
     *
     * @param dateEvaluation
     * @return An Object EvaluationCommand whose dateEvaluation is equals to the given dateEvaluation. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.dateEvaluation = :dateEvaluation and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByDateEvaluation(@Param("dateEvaluation")Date dateEvaluation, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object EvaluationCommand whose statusId is equals to the given statusId. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object EvaluationCommand whose updatedBy is equals to the given updatedBy. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object EvaluationCommand whose isDeleted is equals to the given isDeleted. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object EvaluationCommand whose createdBy is equals to the given createdBy. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object EvaluationCommand whose deletedAt is equals to the given deletedAt. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object EvaluationCommand whose updatedAt is equals to the given updatedAt. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds EvaluationCommand by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object EvaluationCommand whose createdAt is equals to the given createdAt. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds EvaluationCommand by using commandeId as a search criteria.
     *
     * @param commandeId
     * @return An Object EvaluationCommand whose commandeId is equals to the given commandeId. If
     *         no EvaluationCommand is found, this method returns null.
     */
    @Query("select e from EvaluationCommand e where e.command.id = :commandeId and e.isDeleted = :isDeleted")
    List<EvaluationCommand> findByCommandeId(@Param("commandeId")Integer commandeId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one EvaluationCommand by using commandeId as a search criteria.
   *
   * @param commandeId
   * @return An Object EvaluationCommand whose commandeId is equals to the given commandeId. If
   *         no EvaluationCommand is found, this method returns null.
   */
  @Query("select e from EvaluationCommand e where e.command.id = :commandeId and e.isDeleted = :isDeleted")
  EvaluationCommand findEvaluationCommandByCommandeId(@Param("commandeId")Integer commandeId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of EvaluationCommand by using evaluationCommandDto as a search criteria.
     *
     * @param request, em
     * @return A List of EvaluationCommand
     * @throws DataAccessException,ParseException
     */
    public default List<EvaluationCommand> getByCriteria(Request<EvaluationCommandDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from EvaluationCommand e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<EvaluationCommand> query = em.createQuery(req, EvaluationCommand.class);
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
     * Finds count of EvaluationCommand by using evaluationCommandDto as a search criteria.
     *
     * @param request, em
     * @return Number of EvaluationCommand
     *
     */
    public default Long count(Request<EvaluationCommandDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from EvaluationCommand e where e IS NOT NULL";
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
    default String getWhereExpression(Request<EvaluationCommandDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        EvaluationCommandDto dto = request.getData() != null ? request.getData() : new EvaluationCommandDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (EvaluationCommandDto elt : request.getDatas()) {
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
    default String generateCriteria(EvaluationCommandDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (dto.getNoteRapidite() != null || Utilities.searchParamIsNotEmpty(dto.getNoteRapiditeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("noteRapidite", dto.getNoteRapidite(), "e.noteRapidite", "Integer", dto.getNoteRapiditeParam(), param, index, locale));
            }
            if (dto.getNotePrestation() != null || Utilities.searchParamIsNotEmpty(dto.getNotePrestationParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("notePrestation", dto.getNotePrestation(), "e.notePrestation", "Integer", dto.getNotePrestationParam(), param, index, locale));
            }
            if (dto.getNoteConservation() != null || Utilities.searchParamIsNotEmpty(dto.getNoteConservationParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("noteConservation", dto.getNoteConservation(), "e.noteConservation", "Integer", dto.getNoteConservationParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCommentairePrestation()) || Utilities.searchParamIsNotEmpty(dto.getCommentairePrestationParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("commentairePrestation", dto.getCommentairePrestation(), "e.commentairePrestation", "String", dto.getCommentairePrestationParam(), param, index, locale));
            }
            if (dto.getDateEvaluation() != null || Utilities.searchParamIsNotEmpty(dto.getDateEvaluationParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateEvaluation", dto.getDateEvaluation(), "e.dateEvaluation", "Date", dto.getDateEvaluationParam(), param, index, locale));
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

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
