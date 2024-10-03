
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
 * Repository customize : PrestationMoyenDeplacement.
 *
 * @author Geo
 *
 */
@Repository
public interface _PrestationMoyenDeplacementRepository {
	    /**
     * Finds PrestationMoyenDeplacement by using id as a search criteria.
     *
     * @param id
     * @return An Object PrestationMoyenDeplacement whose id is equals to the given id. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.id = :id and e.isDeleted = :isDeleted")
    PrestationMoyenDeplacement findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds PrestationMoyenDeplacement by using dateDebut as a search criteria.
     *
     * @param dateDebut
     * @return An Object PrestationMoyenDeplacement whose dateDebut is equals to the given dateDebut. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.dateDebut = :dateDebut and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByDateDebut(@Param("dateDebut")Date dateDebut, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using dateFin as a search criteria.
     *
     * @param dateFin
     * @return An Object PrestationMoyenDeplacement whose dateFin is equals to the given dateFin. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.dateFin = :dateFin and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByDateFin(@Param("dateFin")Date dateFin, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object PrestationMoyenDeplacement whose statusId is equals to the given statusId. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object PrestationMoyenDeplacement whose updatedBy is equals to the given updatedBy. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object PrestationMoyenDeplacement whose isDeleted is equals to the given isDeleted. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object PrestationMoyenDeplacement whose createdBy is equals to the given createdBy. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object PrestationMoyenDeplacement whose deletedAt is equals to the given deletedAt. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object PrestationMoyenDeplacement whose updatedAt is equals to the given updatedAt. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds PrestationMoyenDeplacement by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object PrestationMoyenDeplacement whose createdAt is equals to the given createdAt. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds PrestationMoyenDeplacement by using moyenDeplacementId as a search criteria.
     *
     * @param moyenDeplacementId
     * @return An Object PrestationMoyenDeplacement whose moyenDeplacementId is equals to the given moyenDeplacementId. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.moyenDeplacement.id = :moyenDeplacementId and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByMoyenDeplacementId(@Param("moyenDeplacementId")Integer moyenDeplacementId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one PrestationMoyenDeplacement by using moyenDeplacementId as a search criteria.
   *
   * @param moyenDeplacementId
   * @return An Object PrestationMoyenDeplacement whose moyenDeplacementId is equals to the given moyenDeplacementId. If
   *         no PrestationMoyenDeplacement is found, this method returns null.
   */
  @Query("select e from PrestationMoyenDeplacement e where e.moyenDeplacement.id = :moyenDeplacementId and e.isDeleted = :isDeleted")
  PrestationMoyenDeplacement findPrestationMoyenDeplacementByMoyenDeplacementId(@Param("moyenDeplacementId")Integer moyenDeplacementId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds PrestationMoyenDeplacement by using presatationId as a search criteria.
     *
     * @param presatationId
     * @return An Object PrestationMoyenDeplacement whose presatationId is equals to the given presatationId. If
     *         no PrestationMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from PrestationMoyenDeplacement e where e.prestation.id = :presatationId and e.isDeleted = :isDeleted")
    List<PrestationMoyenDeplacement> findByPresatationId(@Param("presatationId")Integer presatationId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one PrestationMoyenDeplacement by using presatationId as a search criteria.
   *
   * @param presatationId
   * @return An Object PrestationMoyenDeplacement whose presatationId is equals to the given presatationId. If
   *         no PrestationMoyenDeplacement is found, this method returns null.
   */
  @Query("select e from PrestationMoyenDeplacement e where e.prestation.id = :presatationId and e.isDeleted = :isDeleted")
  PrestationMoyenDeplacement findPrestationMoyenDeplacementByPresatationId(@Param("presatationId")Integer presatationId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of PrestationMoyenDeplacement by using prestationMoyenDeplacementDto as a search criteria.
     *
     * @param request, em
     * @return A List of PrestationMoyenDeplacement
     * @throws DataAccessException,ParseException
     */
    public default List<PrestationMoyenDeplacement> getByCriteria(Request<PrestationMoyenDeplacementDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from PrestationMoyenDeplacement e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<PrestationMoyenDeplacement> query = em.createQuery(req, PrestationMoyenDeplacement.class);
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
     * Finds count of PrestationMoyenDeplacement by using prestationMoyenDeplacementDto as a search criteria.
     *
     * @param request, em
     * @return Number of PrestationMoyenDeplacement
     *
     */
    public default Long count(Request<PrestationMoyenDeplacementDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from PrestationMoyenDeplacement e where e IS NOT NULL";
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
    default String getWhereExpression(Request<PrestationMoyenDeplacementDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        PrestationMoyenDeplacementDto dto = request.getData() != null ? request.getData() : new PrestationMoyenDeplacementDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (PrestationMoyenDeplacementDto elt : request.getDatas()) {
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
    default String generateCriteria(PrestationMoyenDeplacementDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDateDebut()) || Utilities.searchParamIsNotEmpty(dto.getDateDebutParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateDebut", dto.getDateDebut(), "e.dateDebut", "Date", dto.getDateDebutParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDateFin()) || Utilities.searchParamIsNotEmpty(dto.getDateFinParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateFin", dto.getDateFin(), "e.dateFin", "Date", dto.getDateFinParam(), param, index, locale));
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
                        if (dto.getMoyenDeplacementId() != null || Utilities.searchParamIsNotEmpty(dto.getMoyenDeplacementIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("moyenDeplacementId", dto.getMoyenDeplacementId(), "e.moyenDeplacement.id", "Integer", dto.getMoyenDeplacementIdParam(), param, index, locale));
            }
                        if (dto.getPresatationId() != null || Utilities.searchParamIsNotEmpty(dto.getPresatationIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("presatationId", dto.getPresatationId(), "e.prestation.id", "Integer", dto.getPresatationIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getMoyenDeplacementLibelle()) || Utilities.searchParamIsNotEmpty(dto.getMoyenDeplacementLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("moyenDeplacementLibelle", dto.getMoyenDeplacementLibelle(), "e.moyenDeplacement.libelle", "String", dto.getMoyenDeplacementLibelleParam(), param, index, locale));
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
