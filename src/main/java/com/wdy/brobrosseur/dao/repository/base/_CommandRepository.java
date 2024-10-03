
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
 * Repository customize : Command.
 *
 * @author Geo
 *
 */
@Repository
public interface _CommandRepository {
	    /**
     * Finds Command by using id as a search criteria.
     *
     * @param id
     * @return An Object Command whose id is equals to the given id. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.id = :id and e.isDeleted = :isDeleted")
    Command findOne(@Param("id")Integer id, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Command by using typeCommand as a search criteria.
     *
     * @param typeCommand
     * @return An Object Command whose typeCommand is equals to the given typeCommand. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.typeCommand = :typeCommand and e.isDeleted = :isDeleted")
    List<Command> findByTypeCommand(@Param("typeCommand")String typeCommand, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using latitudeLivraison as a search criteria.
     *
     * @param latitudeLivraison
     * @return An Object Command whose latitudeLivraison is equals to the given latitudeLivraison. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.latitudeLivraison = :latitudeLivraison and e.isDeleted = :isDeleted")
    List<Command> findByLatitudeLivraison(@Param("latitudeLivraison")String latitudeLivraison, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using note as a search criteria.
     *
     * @param note
     * @return An Object Command whose note is equals to the given note. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.note = :note and e.isDeleted = :isDeleted")
    List<Command> findByNote(@Param("note")Integer note, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using longitudeLivraison as a search criteria.
     *
     * @param longitudeLivraison
     * @return An Object Command whose longitudeLivraison is equals to the given longitudeLivraison. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.longitudeLivraison = :longitudeLivraison and e.isDeleted = :isDeleted")
    List<Command> findByLongitudeLivraison(@Param("longitudeLivraison")String longitudeLivraison, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using statusId as a search criteria.
     *
     * @param statusId
     * @return An Object Command whose statusId is equals to the given statusId. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.statusId = :statusId and e.isDeleted = :isDeleted")
    List<Command> findByStatusId(@Param("statusId")Integer statusId, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using updatedBy as a search criteria.
     *
     * @param updatedBy
     * @return An Object Command whose updatedBy is equals to the given updatedBy. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.updatedBy = :updatedBy and e.isDeleted = :isDeleted")
    List<Command> findByUpdatedBy(@Param("updatedBy")Integer updatedBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using isDeleted as a search criteria.
     *
     * @param isDeleted
     * @return An Object Command whose isDeleted is equals to the given isDeleted. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.isDeleted = :isDeleted")
    List<Command> findByIsDeleted(@Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using createdBy as a search criteria.
     *
     * @param createdBy
     * @return An Object Command whose createdBy is equals to the given createdBy. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.createdBy = :createdBy and e.isDeleted = :isDeleted")
    List<Command> findByCreatedBy(@Param("createdBy")Integer createdBy, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using deletedAt as a search criteria.
     *
     * @param deletedAt
     * @return An Object Command whose deletedAt is equals to the given deletedAt. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.deletedAt = :deletedAt and e.isDeleted = :isDeleted")
    List<Command> findByDeletedAt(@Param("deletedAt")Date deletedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using updatedAt as a search criteria.
     *
     * @param updatedAt
     * @return An Object Command whose updatedAt is equals to the given updatedAt. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.updatedAt = :updatedAt and e.isDeleted = :isDeleted")
    List<Command> findByUpdatedAt(@Param("updatedAt")Date updatedAt, @Param("isDeleted")Boolean isDeleted);
    /**
     * Finds Command by using createdAt as a search criteria.
     *
     * @param createdAt
     * @return An Object Command whose createdAt is equals to the given createdAt. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.createdAt = :createdAt and e.isDeleted = :isDeleted")
    List<Command> findByCreatedAt(@Param("createdAt")Date createdAt, @Param("isDeleted")Boolean isDeleted);

    /**
     * Finds Command by using utilisateurId as a search criteria.
     *
     * @param utilisateurId
     * @return An Object Command whose utilisateurId is equals to the given utilisateurId. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.utilisateur.id = :utilisateurId and e.isDeleted = :isDeleted")
    List<Command> findByUtilisateurId(@Param("utilisateurId")Integer utilisateurId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Command by using utilisateurId as a search criteria.
   *
   * @param utilisateurId
   * @return An Object Command whose utilisateurId is equals to the given utilisateurId. If
   *         no Command is found, this method returns null.
   */
  @Query("select e from Command e where e.utilisateur.id = :utilisateurId and e.isDeleted = :isDeleted")
  Command findCommandByUtilisateurId(@Param("utilisateurId")Integer utilisateurId, @Param("isDeleted")Boolean isDeleted);


    /**
     * Finds Command by using prestationId as a search criteria.
     *
     * @param prestationId
     * @return An Object Command whose prestationId is equals to the given prestationId. If
     *         no Command is found, this method returns null.
     */
    @Query("select e from Command e where e.prestation.id = :prestationId and e.isDeleted = :isDeleted")
    List<Command> findByPrestationId(@Param("prestationId")Integer prestationId, @Param("isDeleted")Boolean isDeleted);

  /**
   * Finds one Command by using prestationId as a search criteria.
   *
   * @param prestationId
   * @return An Object Command whose prestationId is equals to the given prestationId. If
   *         no Command is found, this method returns null.
   */
  @Query("select e from Command e where e.prestation.id = :prestationId and e.isDeleted = :isDeleted")
  Command findCommandByPrestationId(@Param("prestationId")Integer prestationId, @Param("isDeleted")Boolean isDeleted);




    /**
     * Finds List of Command by using commandDto as a search criteria.
     *
     * @param request, em
     * @return A List of Command
     * @throws DataAccessException,ParseException
     */
    public default List<Command> getByCriteria(Request<CommandDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception {
        String req = "select e from Command e where e IS NOT NULL";
        HashMap<String, Object> param = new HashMap<String, Object>();
        req += getWhereExpression(request, param, locale);
                TypedQuery<Command> query = em.createQuery(req, Command.class);
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
     * Finds count of Command by using commandDto as a search criteria.
     *
     * @param request, em
     * @return Number of Command
     *
     */
    public default Long count(Request<CommandDto> request, EntityManager em, Locale locale) throws DataAccessException, Exception  {
        String req = "select count(e.id) from Command e where e IS NOT NULL";
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
    default String getWhereExpression(Request<CommandDto> request, HashMap<String, java.lang.Object> param, Locale locale) throws Exception {
        // main query
        CommandDto dto = request.getData() != null ? request.getData() : new CommandDto();
        dto.setIsDeleted(false);
        String mainReq = generateCriteria(dto, param, 0, locale);
        // others query
        String othersReq = "";
        if (request.getDatas() != null && !request.getDatas().isEmpty()) {
            Integer index = 1;
            for (CommandDto elt : request.getDatas()) {
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
    default String generateCriteria(CommandDto dto, HashMap<String, Object> param, Integer index,  Locale locale) throws Exception{
        List<String> listOfQuery = new ArrayList<String>();
        if (dto != null) {
            if (dto.getId() != null || Utilities.searchParamIsNotEmpty(dto.getIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("id", dto.getId(), "e.id", "Integer", dto.getIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getTypeCommand()) || Utilities.searchParamIsNotEmpty(dto.getTypeCommandParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("typeCommand", dto.getTypeCommand(), "e.typeCommand", "String", dto.getTypeCommandParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLatitudeLivraison()) || Utilities.searchParamIsNotEmpty(dto.getLatitudeLivraisonParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("latitudeLivraison", dto.getLatitudeLivraison(), "e.latitudeLivraison", "String", dto.getLatitudeLivraisonParam(), param, index, locale));
            }
            if (dto.getNote() != null || Utilities.searchParamIsNotEmpty(dto.getNoteParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("note", dto.getNote(), "e.note", "Integer", dto.getNoteParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getLongitudeLivraison()) || Utilities.searchParamIsNotEmpty(dto.getLongitudeLivraisonParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("longitudeLivraison", dto.getLongitudeLivraison(), "e.longitudeLivraison", "String", dto.getLongitudeLivraisonParam(), param, index, locale));
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
                        if (dto.getUtilisateurId() != null || Utilities.searchParamIsNotEmpty(dto.getUtilisateurIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("utilisateurId", dto.getUtilisateurId(), "e.utilisateur.id", "Integer", dto.getUtilisateurIdParam(), param, index, locale));
            }
                        if (dto.getPrestationId() != null || Utilities.searchParamIsNotEmpty(dto.getPrestationIdParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("prestationId", dto.getPrestationId(), "e.prestation.id", "Integer", dto.getPrestationIdParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUtilisateurNom()) || Utilities.searchParamIsNotEmpty(dto.getUtilisateurNomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("utilisateurNom", dto.getUtilisateurNom(), "e.utilisateur.nom", "String", dto.getUtilisateurNomParam(), param, index, locale));
            }
            if (Utilities.isNotBlank(dto.getUtilisateurPrenom()) || Utilities.searchParamIsNotEmpty(dto.getUtilisateurPrenomParam())) {
                listOfQuery.add(CriteriaUtils.generateCriteria("utilisateurPrenom", dto.getUtilisateurPrenom(), "e.utilisateur.prenom", "String", dto.getUtilisateurPrenomParam(), param, index, locale));
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
