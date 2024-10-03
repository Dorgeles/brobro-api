
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
 * Repository customize : CoursierMoyenDeplacement.
 *
 * @author Geo
 *
 */
@Repository
public interface _CoursierMoyenDeplacementRepository {
	    /**
     * Finds CoursierMoyenDeplacement by using id as a search criteria.
     *
     * @param id
     * @return An Object CoursierMoyenDeplacement whose id is equals to the given id. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.id = :id and e.isDeleted = :isDeleted")
    CoursierMoyenDeplacement findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds CoursierMoyenDeplacement by using dateDebut as a search criteria.
     *
     * @param dateDebut
     * @return An Object CoursierMoyenDeplacement whose dateDebut is equals to the given dateDebut. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.dateDebut = :dateDebut and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByDateDebut(@Param("dateDebut")Date dateDebut, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using dateFin as a search criteria.
     *
     * @param dateFin
     * @return An Object CoursierMoyenDeplacement whose dateFin is equals to the given dateFin. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.dateFin = :dateFin and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByDateFin(@Param("dateFin")Date dateFin, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object CoursierMoyenDeplacement whose statusId is equals to the given statusId. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object CoursierMoyenDeplacement whose updatedBy is equals to the given updatedBy. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object CoursierMoyenDeplacement whose isDeleted is equals to the given isDeleted. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object CoursierMoyenDeplacement whose createdBy is equals to the given createdBy. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object CoursierMoyenDeplacement whose deletedAt is equals to the given deletedAt. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object CoursierMoyenDeplacement whose updatedAt is equals to the given updatedAt. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds CoursierMoyenDeplacement by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object CoursierMoyenDeplacement whose createdAt is equals to the given createdAt. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds CoursierMoyenDeplacement by using moyenDeplacementId as a search criteria.
     *
     * @param moyenDeplacementId
     * @return An Object CoursierMoyenDeplacement whose moyenDeplacementId is equals to the given moyenDeplacementId. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.moyenDeplacement.id = :moyenDeplacementId and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByMoyenDeplacementId(@Param("moyenDeplacementId")Integer moyenDeplacementId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one CoursierMoyenDeplacement by using moyenDeplacementId as a search criteria.
   *
   * @param moyenDeplacementId
   * @return An Object CoursierMoyenDeplacement whose moyenDeplacementId is equals to the given moyenDeplacementId. If
   *         no CoursierMoyenDeplacement is found, this method returns null.
   */
  @Query("select e from CoursierMoyenDeplacement e where e.moyenDeplacement.id = :moyenDeplacementId and e.isDeleted = :isDeleted")
  CoursierMoyenDeplacement findCoursierMoyenDeplacementByMoyenDeplacementId(@Param("moyenDeplacementId")Integer moyenDeplacementId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds CoursierMoyenDeplacement by using coursierId as a search criteria.
     *
     * @param coursierId
     * @return An Object CoursierMoyenDeplacement whose coursierId is equals to the given coursierId. If
     *         no CoursierMoyenDeplacement is found, this method returns null.
     */
    @Query("select e from CoursierMoyenDeplacement e where e.coursier.id = :coursierId and e.isDeleted = :isDeleted")
    List<CoursierMoyenDeplacement> findByCoursierId(@Param("coursierId")Integer coursierId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one CoursierMoyenDeplacement by using coursierId as a search criteria.
   *
   * @param coursierId
   * @return An Object CoursierMoyenDeplacement whose coursierId is equals to the given coursierId. If
   *         no CoursierMoyenDeplacement is found, this method returns null.
   */
  @Query("select e from CoursierMoyenDeplacement e where e.coursier.id = :coursierId and e.isDeleted = :isDeleted")
  CoursierMoyenDeplacement findCoursierMoyenDeplacementByCoursierId(@Param("coursierId")Integer coursierId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of CoursierMoyenDeplacement by using coursierMoyenDeplacementDto as a search criteria.
     *
     * @param request, em
     * @return A List of CoursierMoyenDeplacement
     * @throws DataAccessException,ParseException
     */
    public default List<CoursierMoyenDeplacement> getByCriteria(Request<CoursierMoyenDeplacementDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from CoursierMoyenDeplacement e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<CoursierMoyenDeplacement> query = em.createQuery(req, CoursierMoyenDeplacement.class);
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
     * Finds count of CoursierMoyenDeplacement by using coursierMoyenDeplacementDto as a search criteria.
     *
     * @param request, em
     * @return Number of CoursierMoyenDeplacement
     *
     */
    public default Long count(Request<CoursierMoyenDeplacementDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from CoursierMoyenDeplacement e where e IS NOT NULL";
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
    default String getWhereExpression(Request<CoursierMoyenDeplacementDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        CoursierMoyenDeplacementDto dto = request.getData() != null ? request.getData() : new CoursierMoyenDeplacementDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (CoursierMoyenDeplacementDto elt : request.getDatas()) {
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
    default String generateCriteria(CoursierMoyenDeplacementDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
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
                        if (dto.getCoursierId() != null || Utilities.searchParamIsNotEmpty(dto.getCoursierIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("coursierId", dto.getCoursierId(), "e.coursier.id", "Integer", dto.getCoursierIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getMoyenDeplacementLibelle()) || Utilities.searchParamIsNotEmpty(dto.getMoyenDeplacementLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("moyenDeplacementLibelle", dto.getMoyenDeplacementLibelle(), "e.moyenDeplacement.libelle", "String", dto.getMoyenDeplacementLibelleParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
