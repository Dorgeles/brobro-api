

package com.wdy.brobrosseur.dao.repository;

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
import com.wdy.brobrosseur.dao.repository.base._UtilisateurRepository;

/**
 * Repository : Utilisateur.
 *
 * @author Geo
 */
@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer>, _UtilisateurRepository {

}
