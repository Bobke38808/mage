
package mage.cards.g;

import java.util.UUID;
import mage.abilities.common.DiesCreatureTriggeredAbility;
import mage.abilities.effects.common.CreateTokenEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.TargetController;
import mage.filter.common.FilterCreaturePermanent;
import mage.filter.predicate.permanent.TokenPredicate;
import mage.game.permanent.token.SaprolingToken;

/**
 *
 * @author Wehk
 */
public final class GolgariGermination extends CardImpl {

    private static final FilterCreaturePermanent filter = new FilterCreaturePermanent("nontoken creature you control");
    
    static {
        filter.add(TargetController.YOU.getControllerPredicate());
        filter.add(TokenPredicate.FALSE);
    }    
    
    public GolgariGermination(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.ENCHANTMENT},"{1}{B}{G}");

        // Whenever a nontoken creature you control dies, create a 1/1 green Saproling creature token.
        this.addAbility(new DiesCreatureTriggeredAbility(new CreateTokenEffect(new SaprolingToken()), false, filter));
    }

    private GolgariGermination(final GolgariGermination card) {
        super(card);
    }

    @Override
    public GolgariGermination copy() {
        return new GolgariGermination(this);
    }
}
