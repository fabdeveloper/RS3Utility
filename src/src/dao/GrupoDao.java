package src.dao;

import javax.enterprise.context.Dependent;

import src.entity.Grupo;

@Dependent
public class GrupoDao extends AbstractDao<Grupo> {

	public GrupoDao() {
		super(Grupo.class);
	}

}
