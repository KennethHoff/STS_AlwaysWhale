package STS_AlwaysWhale;

import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;

import basemod.BaseMod;
import basemod.ModLabeledToggleButton;
import basemod.ModPanel;

import com.megacrit.cardcrawl.core.Settings;
import com.megacrit.cardcrawl.helpers.FontHelper;


import basemod.interfaces.PostDungeonInitializeSubscriber;
import basemod.interfaces.PostInitializeSubscriber;


@SpireInitializer
public class STS_AlwaysWhale implements PostDungeonInitializeSubscriber, PostInitializeSubscriber {
	
	public static final String MODNAME = "Always Whale";
	public static final String AUTHOR = "Modernkennnern";
	public static final String DESCRIPTION = "v0.0.1\nRemoves the whale prerequisite of getting to the first boss";
	
	public static final float BUTTON_ENABLE_X = 350.0f;
	public static final float BUTTON_ENABLE_Y = 750.0f;
	
	public static Boolean AlwaysWhale = true;
	
	public STS_AlwaysWhale() {
		BaseMod.subscribe(this);
	}
	
	public static void initialize() {
		new STS_AlwaysWhale();
	}
	
	@Override
	public void receivePostDungeonInitialize() {
		
		if (AlwaysWhale) {
			// Do Neow's Blessing
			Settings.isTestingNeow = true;
		}
		
	}
	
    @Override
    public void receivePostInitialize() {
        // Mod badge
        Texture badgeTexture = new Texture("images/AlwaysWhale.png");
        
        ModPanel settingsPanel = new ModPanel();
        
        ModLabeledToggleButton enableAlwaysWhale = new ModLabeledToggleButton("Enable Always Whale",
        		BUTTON_ENABLE_X, BUTTON_ENABLE_Y, Settings.CREAM_COLOR, FontHelper.charDescFont,
        		AlwaysWhale, settingsPanel, (label) -> {}, (button) -> {
        			SetBoolean(button.enabled);
        		});
        
        settingsPanel.addUIElement(enableAlwaysWhale);
        
        
//        settingsPanel.addLabel("This mod does not have any settings.", 400.0f, 700.0f, (me) -> {});
        BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
    }
    
    public void SetBoolean(Boolean bool) {
    	AlwaysWhale = bool;
    }
	
}
