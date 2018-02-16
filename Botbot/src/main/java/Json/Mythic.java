/*
 * Gregory Pellegrin
 * pellegrin.gregory.work@gmail.com
 */
package Json;

import java.util.List;

public class Mythic
{
	private _links _links;
	private int current_period;
	private Double current_period_start_timestamp;
	private Double current_period_end_timestamp;
	private List <current_keystone_affixes> current_keystone_affixes;
	
	private class _links
	{
		private self self;
		
		private class self
		{
			private String href;
		}
	}
	
	private class current_keystone_affixes
	{
		private keystone_affix keystone_affix;
		private int starting_level;
		
		private class keystone_affix
		{
			private key key;
			private String name;
			private int id;
			
			private class key
			{
				private String href;
			}
		}
	}
	
	private String getCurrentKeyStone (String affixe)
	{
		String aggrave     = "Aggravé - Tant que leurs points de vie sont en dessous de 90%, les personnages-joueurs subissent des dégâts sur la durée croissants, jusqu’à ce qu’ils soient soignés au-delà de 90% de leurs points de vie";
		String debordant   = "Débordant - Quand les points de vie d’une cible sont au maximum, l’excès de soins est converti en effet d’absorption de soins";
		String dechaine    = "Déchaîné - Les ennemis normaux deviennent enragés à 30% de points de vie, ce qui augmente leurs dégâts de 100% jusqu’à leur mort";
		String detonant    = "Détonant - Quand un ennemi normal meurt, il explose et inflige aux personnages-joueurs un montant de dégâts égal à 10% de leur maximum de points de vie en 4 secondes. Effet cumulable";
		String explosif    = "Explosif - En combat, les ennemis invoquent périodiquement des orbes explosifs qui détonent s’ils ne sont pas détruits";
		String febrile     = "Fébrile - Les ennemis prêtent beaucoup moins attention à la menace générée par les tanks";
		String fortifie    = "Fortifié - Les ennemis normaux ont 20% de points de vie supplémentaires et leurs dégâts sont augmentés d’au maximum 30%";
		String galvanisant = "Galvanisant - Quand un ennemi normal meurt, son cri d’agonie renforce ses alliés proches, ce qui augmente leur maximum de points de vie et leurs dégâts de 20%";
		String grouillant  = "Grouillant - Des ennemis normaux supplémentaires sont présents dans tout le donjon";
		String implacable  = "Implacable - Les ennemis normaux deviennent temporairement insensibles aux effets de perte de contrôle";
		String necrotique  = "Nécrotique - Les attaques de mêlée des ennemis appliquent un chancre cumulable qui inflige des dégâts sur la durée et réduit les soins reçus";
		String sanguin     = "Sanguin - Quand un ennemi normal meurt, il laisse derrière lui une flaque d’ichor qui soigne ses alliés et inflige des dégâts aux personnages-joueurs";
		String sismique    = "Sismique - Tous les personnages-joueurs émettent régulièrement une onde de choc qui inflige des dégâts aux alliés proches et les interrompt";
		String tyrannique  = "Tyrannique - Les boss ont 40% de points de vie supplémentaires et leurs dégâts sont augmentés d’au maximum 15%";
		String volcanique  = "Volcanique - En combat, les ennemis font périodiquement apparaître des gerbes de flammes sous les pieds des personnages-joueurs éloignés";
		
		if (affixe.equals("Aggravé"))
			return aggrave;
		else if (affixe.equals("Débordant"))
			return debordant;
		else if (affixe.equals("Déchaîné"))
			return dechaine;
		else if (affixe.equals("Détonant"))
			return detonant;
		else if (affixe.equals("Explosif"))
			return explosif;
		else if (affixe.equals("Fébrile"))
			return febrile;
		else if (affixe.equals("Fortifié"))
			return fortifie;
		else if (affixe.equals("Galvanisant"))
			return galvanisant;
		else if (affixe.equals("Grouillant"))
			return grouillant;
		else if (affixe.equals("Implacable"))
			return implacable;
		else if (affixe.equals("Nécrotique"))
			return necrotique;
		else if (affixe.equals("Sanguin"))
			return sanguin;
		else if (affixe.equals("Sismique"))
			return sismique;
		else if (affixe.equals("Tyrannique"))
			return tyrannique;
		else if (affixe.equals("Volcanique"))
			return volcanique;
		else
			return "Erreur pour obtenir la description, les affixes ont changés";
	}
	
	@Override
	public String toString ()
	{
		if (this.current_keystone_affixes.size() != 3)
			return "Erreur pour obtenir les statistiques, le Json a changé";
		
		String affixe4 = "";
		String affixe7 = "";
		String affixe10 = "";
		
		for (int i = 0; i < this.current_keystone_affixes.size(); i++)
		{
			if (this.current_keystone_affixes.get(i).starting_level == 4)
				affixe4 = getCurrentKeyStone(this.current_keystone_affixes.get(i).keystone_affix.name);
			else if (this.current_keystone_affixes.get(i).starting_level == 7)
				affixe7 = getCurrentKeyStone(this.current_keystone_affixes.get(i).keystone_affix.name);
			else if (this.current_keystone_affixes.get(i).starting_level == 10)
				affixe10 = getCurrentKeyStone(this.current_keystone_affixes.get(i).keystone_affix.name);
		}
		
		return affixe4 + "\n" +
			   affixe7 + "\n" +
			   affixe10;
	}
}