package com.ecommerce.microcommerce.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ecommerce.microcommerce.model.Product;
import com.ecommerce.microcommerce.web.exceptions.ProduitGratuitException;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {

	Product findById(int id);

	List<Product> findByPrixGreaterThan(int prixLimit);

	List<Product> findByNomLike(String recherche);

	@Query("SELECT id, nom, prix FROM Product p WHERE p.prix > :prixLimit")
	List<Product> chercherUnProduitCher(@Param("prixLimit") int prix);

	Iterable<Product> findAllByOrderByNom();

	@Override
	default <S extends Product> S save(S s) {
		int prix = s.getPrix();
		if (prix <= 0) {
			throw new ProduitGratuitException("Le produit " + s.getId() + " ne peut pas être gratuit");
		}
		s = this.save(s);
		return s;
	}

}
