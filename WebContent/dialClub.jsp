
	<div id="dialog-club" hidden>
		<h1>Nouveau club</h1>
		<table>
			<tr>
				<td>Référence Club</td>
				<td><input type="text" size="10" placeholder="Obligatoire" id="dialClub_ref" /></td>
			</tr>
			<tr>
				<td>Nom</td>
				<td><input type="text" placeholder="Obligatoire" id="dialClub_nonClub" /></td>
			</tr>
			<tr>
				<td>Nom du contact</td>
				<td><input type="text" id="dialClub_nomContact" /></td>
			</tr>
			<tr>
				<td>Adresse ligne 1</td>
				<td><input type="text" size="30" placeholder="Obligatoire" id="dialClub_adresse1" /></td>
			</tr>
			<tr>
				<td>Adresse ligne 2</td>
				<td><input type="text" size="30" id="dialClub_adresse2" /></td>
			</tr>
			<tr>
				<td>Code postal</td>
				<td><input type="text" size="10" placeholder="Obligatoire" id="dialClub_codePostal" /></td>
			</tr>
			<tr>
				<td>Ville</td>
				<td><input type="text" size="25" placeholder="Obligatoire" id="dialClub_ville" /></td>
			</tr>
			<tr>
				<td colspan="2"><form id="dialClub_IsClient">Déjà client ?
				 <input type="radio" name="choix" value="O"><label for="oui"> Oui</label>
 					<input type="radio" name="choix" value="N"><label for="non"> Non</label>
				</form></td>
			</tr>
			<tr>
				<td>Pays</td>
				<td><input type="text" size="15" id="dialClub_pays" />
				<input hidden value="" id="dialClub_IDpays" /></td>
			</tr>
			<tr>
				<td colspan="2"><div id="dialClub_err"></div></td>
			</tr>
			<tr>
				<td class="tdClub" colspan="2">
					<button class="buttonVal" id="dialClub_valid">Valider</button>
					<button class="buttonVal" id="dialClub_close">Annuler</button>
				</td>
		</table>
	</div>
