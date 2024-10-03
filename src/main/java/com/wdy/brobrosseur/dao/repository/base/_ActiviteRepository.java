
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
 * Repository customize : Activite.
 *
 * @author Geo
 *
 */
@Repository
public interface _ActiviteRepository {
	    /**
     * Finds Activite by using id as a search criteria.
     *
     * @param id
     * @return An Object Activite whose id is equals to the given id. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.id = :id and e.isDeleted = :isDeleted")
    Activite findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Activite by using libelle as a search criteria.
     *
     * @param libelle
     * @return An Object Activite whose libelle is equals to the given libelle. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.libelle = :libelle and e.isDeleted = :isDeleted")
    Activite findByLibelle(@Param("libelle")String libelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using description as a search criteria.
     *
     * @param description
     * @return An Object Activite whose description is equals to the given description. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.description = :description and e.isDeleted = :isDeleted")
    List<Activite> findByDescription(@Param("description")String description, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using latitude as a search criteria.
     *
     * @param latitude
     * @return An Object Activite whose latitude is equals to the given latitude. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.latitude = :latitude and e.isDeleted = :isDeleted")
    List<Activite> findByLatitude(@Param("latitude")String latitude, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using longitude as a search criteria.
     *
     * @param longitude
     * @return An Object Activite whose longitude is equals to the given longitude. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.longitude = :longitude and e.isDeleted = :isDeleted")
    List<Activite> findByLongitude(@Param("longitude")String longitude, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using noteMoyenne as a search criteria.
     *
     * @param noteMoyenne
     * @return An Object Activite whose noteMoyenne is equals to the given noteMoyenne. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.noteMoyenne = :noteMoyenne and e.isDeleted = :isDeleted")
    List<Activite> findByNoteMoyenne(@Param("noteMoyenne")Integer noteMoyenne, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Activite whose statusId is equals to the given statusId. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Activite> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using dateOuverture as a search criteria.
     *
     * @param dateOuverture
     * @return An Object Activite whose dateOuverture is equals to the given dateOuverture. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.dateOuverture = :dateOuverture and e.isDeleted = :isDeleted")
    List<Activite> findByDateOuverture(@Param("dateOuverture")Date dateOuverture, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using dateFermeture as a search criteria.
     *
     * @param dateFermeture
     * @return An Object Activite whose dateFermeture is equals to the given dateFermeture. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.dateFermeture = :dateFermeture and e.isDeleted = :isDeleted")
    List<Activite> findByDateFermeture(@Param("dateFermeture")Date dateFermeture, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Activite whose updatedBy is equals to the given updatedBy. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Activite> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Activite whose isDeleted is equals to the given isDeleted. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.isDeleted = :isDeleted")
    List<Activite> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Activite whose createdBy is equals to the given createdBy. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Activite> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Activite whose deletedAt is equals to the given deletedAt. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Activite> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Activite whose updatedAt is equals to the given updatedAt. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Activite> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Activite whose createdAt is equals to the given createdAt. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Activite> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Activite by using dateFin as a search criteria.
     *
     * @param dateFin
     * @return An Object Activite whose dateFin is equals to the given dateFin. If
     *         no Activite is found, this method returns null.
     */
    @Query("select e from Activite e where e.dateFin = :dateFin and e.isDeleted = :isDeleted")
    List<Activite> findByDateFin(@Param("dateFin")Date dateFin, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Activite by using activiteDto as a search criteria.
     *
     * @param request, em
     * @return A List of Activite
     * @throws DataAccessException,ParseException
     */
    public default List<Activite> getByCriteria(Request<ActiviteDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Activite e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Activite> query = em.createQuery(req, Activite.class);
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
     * Finds count of Activite by using activiteDto as a search criteria.
     *
     * @param request, em
     * @return Number of Activite
     *
     */
    public default Long count(Request<ActiviteDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Activite e where e IS NOT NULL";
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
    default String getWhereExpression(Request<ActiviteDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        ActiviteDto dto = request.getData() != null ? request.getData() : new ActiviteDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (ActiviteDto elt : request.getDatas()) {
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
    default String generateCriteria(ActiviteDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLibelle()) || Utilities.searchParamIsNotEmpty(dto.getLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("libelle", dto.getLibelle(), "e.libelle", "String", dto.getLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDescription()) || Utilities.searchParamIsNotEmpty(dto.getDescriptionParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("description", dto.getDescription(), "e.description", "String", dto.getDescriptionParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLatitude()) || Utilities.searchParamIsNotEmpty(dto.getLatitudeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("latitude", dto.getLatitude(), "e.latitude", "String", dto.getLatitudeParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLongitude()) || Utilities.searchParamIsNotEmpty(dto.getLongitudeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("longitude", dto.getLongitude(), "e.longitude", "String", dto.getLongitudeParam(), param, index, locale));
            }
            if (dto.getNoteMoyenne() != null || Utilities.searchParamIsNotEmpty(dto.getNoteMoyenneParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("noteMoyenne", dto.getNoteMoyenne(), "e.noteMoyenne", "Integer", dto.getNoteMoyenneParam(), param, index, locale));
            }
            if (dto.getStatusId() != null || Utilities.searchParamIsNotEmpty(dto.getStatusIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("statusId", dto.getStatusId(), "e.statusId", "Integer", dto.getStatusIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDateOuverture()) || Utilities.searchParamIsNotEmpty(dto.getDateOuvertureParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateOuverture", dto.getDateOuverture(), "e.dateOuverture", "Date", dto.getDateOuvertureParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDateFermeture()) || Utilities.searchParamIsNotEmpty(dto.getDateFermetureParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateFermeture", dto.getDateFermeture(), "e.dateFermeture", "Date", dto.getDateFermetureParam(), param, index, locale));
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
            if (Utilities.isNotBlank(dto.getDateFin()) || Utilities.searchParamIsNotEmpty(dto.getDateFinParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dateFin", dto.getDateFin(), "e.dateFin", "Date", dto.getDateFinParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
