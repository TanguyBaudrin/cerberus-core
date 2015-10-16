/* DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This file is part of Cerberus.
 *
 * Cerberus is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Cerberus is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Cerberus.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.cerberus.crud.dao;

import java.util.List;
import org.cerberus.crud.entity.Invariant;
import org.cerberus.exception.CerberusException;
import org.cerberus.util.answer.AnswerList;

/**
 * {Insert class description here}
 *
 * @author Tiago Bernardes
 * @version 1.0, 28/Dez/2012
 * @since 2.0.0
 */
public interface IInvariantDAO {

    Invariant findInvariantByIdValue(String idName, String value) throws CerberusException;

    Invariant findInvariantByIdSort(String idName, Integer sort) throws CerberusException;

    List<Invariant> findListOfInvariantById(String idName) throws CerberusException;

    AnswerList<Invariant> findInvariantByIdGp1(String idName, String gp);

    public List<Invariant> findInvariantListByCriteria(int start, int amount, String column, String dir, String searchTerm, String individualSearch, String PublicPrivateFilter);

    public Integer getNumberOfInvariant(String searchTerm, String PublicPrivateFilter) throws CerberusException;

    public void createInvariant(Invariant invariant) throws CerberusException;

    public void deleteInvariant(Invariant invariant) throws CerberusException;

    public void updateInvariant(Invariant invariant) throws CerberusException;
}
