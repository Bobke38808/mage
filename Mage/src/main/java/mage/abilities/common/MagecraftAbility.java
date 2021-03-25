package mage.abilities.common;

import mage.abilities.TriggeredAbilityImpl;
import mage.abilities.effects.Effect;
import mage.constants.Zone;
import mage.game.Game;
import mage.game.events.GameEvent;
import mage.game.stack.Spell;

/**
 * @author TheElk801
 */
public class MagecraftAbility extends TriggeredAbilityImpl {

    public MagecraftAbility(Effect effect, boolean optional) {
        super(Zone.BATTLEFIELD, effect, optional);
    }

    private MagecraftAbility(final MagecraftAbility ability) {
        super(ability);
    }

    @Override
    public boolean checkEventType(GameEvent event, Game game) {
        return event.getType() == GameEvent.EventType.COPIED_STACKOBJECT
                || event.getType() == GameEvent.EventType.SPELL_CAST;
    }

    @Override
    public boolean checkTrigger(GameEvent event, Game game) {
        Spell spell = game.getSpell(event.getTargetId());
        return spell != null && spell.isControlledBy(getControllerId()) && spell.isInstantOrSorcery();
    }

    @Override
    public String getRule() {
        return "<i>Magecraft</i> &mdash; Whenever you cast or copy an instant or sorcery spell, " + super.getRule();
    }

    @Override
    public MagecraftAbility copy() {
        return new MagecraftAbility(this);
    }
}