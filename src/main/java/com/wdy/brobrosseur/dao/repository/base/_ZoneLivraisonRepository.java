
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
 * Repository customize : ZoneLivraison.
 *
 * @author Geo
 *
 */
@Repository
public interface _ZoneLivraisonRepository {
	    /**
     * Finds ZoneLivraison by using id as a search criteria.
     *
     * @param id
     * @return An Object ZoneLivraison whose id is equals to the given id. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.id = :id and e.isDeleted = :isDeleted")
    ZoneLivraison findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds ZoneLivraison by using latitudeDepart as a search criteria.
     *
     * @param latitudeDepart
     * @return An Object ZoneLivraison whose latitudeDepart is equals to the given latitudeDepart. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.latitudeDepart = :latitudeDepart and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByLatitudeDepart(@Param("latitudeDepart")String latitudeDepart, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using longitudeDepart as a search criteria.
     *
     * @param longitudeDepart
     * @return An Object ZoneLivraison whose longitudeDepart is equals to the given longitudeDepart. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.longitudeDepart = :longitudeDepart and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByLongitudeDepart(@Param("longitudeDepart")String longitudeDepart, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using latitudeArrivee as a search criteria.
     *
     * @param latitudeArrivee
     * @return An Object ZoneLivraison whose latitudeArrivee is equals to the given latitudeArrivee. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.latitudeArrivee = :latitudeArrivee and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByLatitudeArrivee(@Param("latitudeArrivee")String latitudeArrivee, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using longitudeArrivee as a search criteria.
     *
     * @param longitudeArrivee
     * @return An Object ZoneLivraison whose longitudeArrivee is equals to the given longitudeArrivee. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.longitudeArrivee = :longitudeArrivee and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByLongitudeArrivee(@Param("longitudeArrivee")String longitudeArrivee, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object ZoneLivraison whose statusId is equals to the given statusId. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object ZoneLivraison whose updatedBy is equals to the given updatedBy. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object ZoneLivraison whose isDeleted is equals to the given isDeleted. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object ZoneLivraison whose createdBy is equals to the given createdBy. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object ZoneLivraison whose deletedAt is equals to the given deletedAt. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object ZoneLivraison whose updatedAt is equals to the given updatedAt. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds ZoneLivraison by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object ZoneLivraison whose createdAt is equals to the given createdAt. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds ZoneLivraison by using coursierId as a search criteria.
     *
     * @param coursierId
     * @return An Object ZoneLivraison whose coursierId is equals to the given coursierId. If
     *         no ZoneLivraison is found, this method returns null.
     */
    @Query("select e from ZoneLivraison e where e.coursier.id = :coursierId and e.isDeleted = :isDeleted")
    List<ZoneLivraison> findByCoursierId(@Param("coursierId")Integer coursierId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one ZoneLivraison by using coursierId as a search criteria.
   *
   * @param coursierId
   * @return An Object ZoneLivraison whose coursierId is equals to the given coursierId. If
   *         no ZoneLivraison is found, this method returns null.
   */
  @Query("select e from ZoneLivraison e where e.coursier.id = :coursierId and e.isDeleted = :isDeleted")
  ZoneLivraison findZoneLivraisonByCoursierId(@Param("coursierId")Integer coursierId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of ZoneLivraison by using zoneLivraisonDto as a search criteria.
     *
     * @param request, em
     * @return A List of ZoneLivraison
     * @throws DataAccessException,ParseException
     */
    public default List<ZoneLivraison> getByCriteria(Request<ZoneLivraisonDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from ZoneLivraison e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<ZoneLivraison> query = em.createQuery(req, ZoneLivraison.class);
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
     * Finds count of ZoneLivraison by using zoneLivraisonDto as a search criteria.
     *
     * @param request, em
     * @return Number of ZoneLivraison
     *
     */
    public default Long count(Request<ZoneLivraisonDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from ZoneLivraison e where e IS NOT NULL";
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
    default String getWhereExpression(Request<ZoneLivraisonDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        ZoneLivraisonDto dto = request.getData() != null ? request.getData() : new ZoneLivraisonDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (ZoneLivraisonDto elt : request.getDatas()) {
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
    default String generateCriteria(ZoneLivraisonDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLatitudeDepart()) || Utilities.searchParamIsNotEmpty(dto.getLatitudeDepartParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("latitudeDepart", dto.getLatitudeDepart(), "e.latitudeDepart", "String", dto.getLatitudeDepartParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLongitudeDepart()) || Utilities.searchParamIsNotEmpty(dto.getLongitudeDepartParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("longitudeDepart", dto.getLongitudeDepart(), "e.longitudeDepart", "String", dto.getLongitudeDepartParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLatitudeArrivee()) || Utilities.searchParamIsNotEmpty(dto.getLatitudeArriveeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("latitudeArrivee", dto.getLatitudeArrivee(), "e.latitudeArrivee", "String", dto.getLatitudeArriveeParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLongitudeArrivee()) || Utilities.searchParamIsNotEmpty(dto.getLongitudeArriveeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("longitudeArrivee", dto.getLongitudeArrivee(), "e.longitudeArrivee", "String", dto.getLongitudeArriveeParam(), param, index, locale));
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
                        if (dto.getCoursierId() != null || Utilities.searchParamIsNotEmpty(dto.getCoursierIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("coursierId", dto.getCoursierId(), "e.coursier.id", "Integer", dto.getCoursierIdParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
