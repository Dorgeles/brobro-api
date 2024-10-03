
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
 * Repository customize : Utilisateur.
 *
 * @author Geo
 *
 */
@Repository
public interface _UtilisateurRepository {
	    /**
     * Finds Utilisateur by using id as a search criteria.
     *
     * @param id
     * @return An Object Utilisateur whose id is equals to the given id. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.id = :id and e.isDeleted = :isDeleted")
    Utilisateur findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Utilisateur by using nom as a search criteria.
     *
     * @param nom
     * @return An Object Utilisateur whose nom is equals to the given nom. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.nom = :nom and e.isDeleted = :isDeleted")
    List<Utilisateur> findByNom(@Param("nom")String nom, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using username as a search criteria.
     *
     * @param username
     * @return An Object Utilisateur whose username is equals to the given username. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.username = :username and e.isDeleted = :isDeleted")
    List<Utilisateur> findByUsername(@Param("username")String username, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using prenom as a search criteria.
     *
     * @param prenom
     * @return An Object Utilisateur whose prenom is equals to the given prenom. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.prenom = :prenom and e.isDeleted = :isDeleted")
    List<Utilisateur> findByPrenom(@Param("prenom")String prenom, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using email as a search criteria.
     *
     * @param email
     * @return An Object Utilisateur whose email is equals to the given email. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.email = :email and e.isDeleted = :isDeleted")
    Utilisateur findByEmail(@Param("email")String email, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using telephone as a search criteria.
     *
     * @param telephone
     * @return An Object Utilisateur whose telephone is equals to the given telephone. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.telephone = :telephone and e.isDeleted = :isDeleted")
    Utilisateur findByTelephone(@Param("telephone")String telephone, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using telephone2 as a search criteria.
     *
     * @param telephone2
     * @return An Object Utilisateur whose telephone2 is equals to the given telephone2. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.telephone2 = :telephone2 and e.isDeleted = :isDeleted")
    List<Utilisateur> findByTelephone2(@Param("telephone2")String telephone2, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using motDePasse as a search criteria.
     *
     * @param motDePasse
     * @return An Object Utilisateur whose motDePasse is equals to the given motDePasse. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.motDePasse = :motDePasse and e.isDeleted = :isDeleted")
    List<Utilisateur> findByMotDePasse(@Param("motDePasse")String motDePasse, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Utilisateur whose statusId is equals to the given statusId. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Utilisateur> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Utilisateur whose updatedBy is equals to the given updatedBy. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Utilisateur> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Utilisateur whose isDeleted is equals to the given isDeleted. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.isDeleted = :isDeleted")
    List<Utilisateur> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Utilisateur whose createdBy is equals to the given createdBy. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Utilisateur> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Utilisateur whose deletedAt is equals to the given deletedAt. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Utilisateur> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using isLocked as a search criteria.
     *
     * @param isLocked
     * @return An Object Utilisateur whose isLocked is equals to the given isLocked. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.isLocked = :isLocked and e.isDeleted = :isDeleted")
    List<Utilisateur> findByIsLocked(@Param("isLocked")Boolean isLocked, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Utilisateur whose updatedAt is equals to the given updatedAt. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Utilisateur> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Utilisateur whose createdAt is equals to the given createdAt. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Utilisateur> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Utilisateur by using typeClient as a search criteria.
     *
     * @param typeClient
     * @return An Object Utilisateur whose typeClient is equals to the given typeClient. If
     *         no Utilisateur is found, this method returns null.
     */
    @Query("select e from Utilisateur e where e.typeClient = :typeClient and e.isDeleted = :isDeleted")
    List<Utilisateur> findByTypeClient(@Param("typeClient")Integer typeClient, @Param("isDeleted")Boolean isDeleted);



    /**
     * Finds List of Utilisateur by using utilisateurDto as a search criteria.
     *
     * @param request, em
     * @return A List of Utilisateur
     * @throws DataAccessException,ParseException
     */
    public default List<Utilisateur> getByCriteria(Request<UtilisateurDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Utilisateur e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Utilisateur> query = em.createQuery(req, Utilisateur.class);
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
     * Finds count of Utilisateur by using utilisateurDto as a search criteria.
     *
     * @param request, em
     * @return Number of Utilisateur
     *
     */
    public default Long count(Request<UtilisateurDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Utilisateur e where e IS NOT NULL";
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
    default String getWhereExpression(Request<UtilisateurDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        UtilisateurDto dto = request.getData() != null ? request.getData() : new UtilisateurDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (UtilisateurDto elt : request.getDatas()) {
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
    default String generateCriteria(UtilisateurDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getNom()) || Utilities.searchParamIsNotEmpty(dto.getNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("nom", dto.getNom(), "e.nom", "String", dto.getNomParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUsername()) || Utilities.searchParamIsNotEmpty(dto.getUsernameParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("username", dto.getUsername(), "e.username", "String", dto.getUsernameParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getPrenom()) || Utilities.searchParamIsNotEmpty(dto.getPrenomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prenom", dto.getPrenom(), "e.prenom", "String", dto.getPrenomParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getEmail()) || Utilities.searchParamIsNotEmpty(dto.getEmailParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("email", dto.getEmail(), "e.email", "String", dto.getEmailParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getTelephone()) || Utilities.searchParamIsNotEmpty(dto.getTelephoneParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("telephone", dto.getTelephone(), "e.telephone", "String", dto.getTelephoneParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getTelephone2()) || Utilities.searchParamIsNotEmpty(dto.getTelephone2Param())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("telephone2", dto.getTelephone2(), "e.telephone2", "String", dto.getTelephone2Param(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getMotDePasse()) || Utilities.searchParamIsNotEmpty(dto.getMotDePasseParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("motDePasse", dto.getMotDePasse(), "e.motDePasse", "String", dto.getMotDePasseParam(), param, index, locale));
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
            if (dto.getIsLocked() != null || Utilities.searchParamIsNotEmpty(dto.getIsLockedParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("isLocked", dto.getIsLocked(), "e.isLocked", "Boolean", dto.getIsLockedParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUpdatedAt()) || Utilities.searchParamIsNotEmpty(dto.getUpdatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("updatedAt", dto.getUpdatedAt(), "e.updatedAt", "Date", dto.getUpdatedAtParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getCreatedAt()) || Utilities.searchParamIsNotEmpty(dto.getCreatedAtParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("createdAt", dto.getCreatedAt(), "e.createdAt", "Date", dto.getCreatedAtParam(), param, index, locale));
            }
            if (dto.getTypeClient() != null || Utilities.searchParamIsNotEmpty(dto.getTypeClientParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("typeClient", dto.getTypeClient(), "e.typeClient", "Integer", dto.getTypeClientParam(), param, index, locale));
            }

            /*List<String> listOfCustomQuery = _generateCriteria(dto, param, index, locale);
            if (Utilities.isNotEmpty(listOfCustomQuery)) {
                listOfQuery.addAll(listOfCustomQuery);
            }*/
        }
        return CriteriaUtils.getCriteriaByListOfQuery(listOfQuery);
    }
}
