
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
 * Repository customize : Prestation.
 *
 * @author Geo
 *
 */
@Repository
public interface _PrestationRepository {
	    /**
     * Finds Prestation by using id as a search criteria.
     *
     * @param id
     * @return An Object Prestation whose id is equals to the given id. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.id = :id and e.isDeleted = :isDeleted")
    Prestation findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Prestation by using projetId as a search criteria.
     *
     * @param projetId
     * @return An Object Prestation whose projetId is equals to the given projetId. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.projetId = :projetId and e.isDeleted = :isDeleted")
    List<Prestation> findByProjetId(@Param("projetId")Integer projetId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using libelle as a search criteria.
     *
     * @param libelle
     * @return An Object Prestation whose libelle is equals to the given libelle. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.libelle = :libelle and e.isDeleted = :isDeleted")
    Prestation findByLibelle(@Param("libelle")String libelle, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using description as a search criteria.
     *
     * @param description
     * @return An Object Prestation whose description is equals to the given description. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.description = :description and e.isDeleted = :isDeleted")
    List<Prestation> findByDescription(@Param("description")String description, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using prix as a search criteria.
     *
     * @param prix
     * @return An Object Prestation whose prix is equals to the given prix. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.prix = :prix and e.isDeleted = :isDeleted")
    List<Prestation> findByPrix(@Param("prix")String prix, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using dureeEstimee as a search criteria.
     *
     * @param dureeEstimee
     * @return An Object Prestation whose dureeEstimee is equals to the given dureeEstimee. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.dureeEstimee = :dureeEstimee and e.isDeleted = :isDeleted")
    List<Prestation> findByDureeEstimee(@Param("dureeEstimee")Integer dureeEstimee, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Prestation whose statusId is equals to the given statusId. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Prestation> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Prestation whose updatedBy is equals to the given updatedBy. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Prestation> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Prestation whose isDeleted is equals to the given isDeleted. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.isDeleted = :isDeleted")
    List<Prestation> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Prestation whose createdBy is equals to the given createdBy. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Prestation> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Prestation whose deletedAt is equals to the given deletedAt. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Prestation> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Prestation whose updatedAt is equals to the given updatedAt. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Prestation> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Prestation by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Prestation whose createdAt is equals to the given createdAt. If
     *         no Prestation is found, this method returns null.
     */
    @Query("select e from Prestation e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Prestation> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Prestation by using prestationDto as a search criteria.
     *
     * @param request, em
     * @return A List of Prestation
     * @throws DataAccessException,ParseException
     */
    public default List<Prestation> getByCriteria(Request<PrestationDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Prestation e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Prestation> query = em.createQuery(req, Prestation.class);
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
     * Finds count of Prestation by using prestationDto as a search criteria.
     *
     * @param request, em
     * @return Number of Prestation
     *
     */
    public default Long count(Request<PrestationDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Prestation e where e IS NOT NULL";
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
    default String getWhereExpression(Request<PrestationDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        PrestationDto dto = request.getData() != null ? request.getData() : new PrestationDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (PrestationDto elt : request.getDatas()) {
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
    default String generateCriteria(PrestationDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (dto.getProjetId() != null || Utilities.searchParamIsNotEmpty(dto.getProjetIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("projetId", dto.getProjetId(), "e.projetId", "Integer", dto.getProjetIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLibelle()) || Utilities.searchParamIsNotEmpty(dto.getLibelleParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("libelle", dto.getLibelle(), "e.libelle", "String", dto.getLibelleParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getDescription()) || Utilities.searchParamIsNotEmpty(dto.getDescriptionParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("description", dto.getDescription(), "e.description", "String", dto.getDescriptionParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrix()) || Utilities.searchParamIsNotEmpty(dto.getPrixParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prix", dto.getPrix(), "e.prix", "String", dto.getPrixParam(), param, index, locale));
            }
            if (dto.getDureeEstimee() != null || Utilities.searchParamIsNotEmpty(dto.getDureeEstimeeParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("dureeEstimee", dto.getDureeEstimee(), "e.dureeEstimee", "Integer", dto.getDureeEstimeeParam(), param, index, locale));
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
