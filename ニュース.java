import java.util.*;

public class �j���[�X {
	
	public static String NewsA(int Number) {
		String[] eventA={"���{��A���Ƃ̊ԂŊ֐�0�ŗA�o�����ł���",
						"A���������̎����ԎY�ƕی�𖾊m�ɂ��A",
						"B�����ԉ�ЂƂ̊֌W���[��C����",
						"�����ĉғ�",
						"�I���ɂ�茴�����Δh�ɓ}������������B",
						"�Η͔R���̗A�����i�㏸",
						"���̔N�̉Ă͔�r�I����������",
						"�G�R�u�[��",
						"���̔N�̓~�͒��Ɋ��̉e���ŏ��g�[�����y����",
						"�����N���ƌ_������ԋс��\���O�����h�X������",
						"�������郆�j�N���A�l�グ�����Ă��܂��B",
						"����ł̏㏸",
						"���{�Ɠ��₪�~���U����������",
						"�I�����s�b�N�̊J��",
						"�����_�Ђ����E��Y�ɓo�^����A���ڂ𗁂т�",
						"�i�C���ǂ��Ȃ���",
						"�������オ����",
						"�~��",
						"���{��s���َ����ɘa��Ƃ���ETF�i��꓊���M���j��",
						"���Z�ɘa������s��",
						"���E�e���ňُ�C�ۂ��ڗ���",
						"�}�c�_�����ԉ�Ђ�BMW�����Ԃ�",
						"���낻��GW",
						"�˒J���񂪖^�ԑg���ŗ��s��Њ���"};
		
		return eventA[Number];
	}
	public static String NewsB(int Number) {
		String[] eventB={
			"�f�Ջ��肪�ł����B",
			"���낢��ȍ����Y�ƕی쐭����Ƃ����B",
			"�o�ϐ������~�܂�B",
			"",
			"",
			"",
			"",
			"",
			"",
			"�^�C�g�������A���E�Ƀ��j�N���̖��������n��",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"",
			"J-REIT�i���{�̏��s���Y�����M���j���ʍw��",
			"",
			"",
			"�q��Љ�����",
			"",
			"�D�Ҍ����Љ�A�b��ɂȂ�"};
		
		return eventB[Number];
	}
	public void �j���[�X�C�x���g����(int eventNumber) {
		
		if (eventNumber==0) kabu.��c���̊����ϓ�(15000);
		if (eventNumber==1) kabu.��c���̊����ϓ�(10000);
		if (eventNumber==2) kabu.��c���̊����ϓ�(15000);
		if (eventNumber==3) kabu.�������̊����ϓ�(15000);
		if (eventNumber==4) kabu.�������̊����ϓ�(-5000);
		if (eventNumber==5) {
			kabu.�������̊����ϓ�(-10000);
			kabu.��c���̊����ϓ�(-3000);
		}if (eventNumber==6) kabu.�������̊����ϓ�(-3000);
		if (eventNumber==7) kabu.�������̊����ϓ�(-3000);
		if (eventNumber==8) {
			kabu.�������̊����ϓ�(2000);
			kabu.�E�`�N�����̊����ϓ�(5000);
		}if (eventNumber==9) kabu.�E�`�N�����̊����ϓ�(2000);
		if (eventNumber==10) {
			kabu.��c���̊����ϓ�(10000);
			kabu.�E�`�N�����̊����ϓ�(-5000);
		}if (eventNumber==11) kabu.�E�`�N�����̊����ϓ�(-4000);
		if (eventNumber==12) {
			kabu.��c���̊����ϓ�(-3000);
			kabu.�������̊����ϓ�(-3000);
			kabu.�E�`�N�����̊����ϓ�(-3000);
			kabu.���i���̊����ϓ�(-3000);
		}if (eventNumber==13) kabu.��c���̊����ϓ�(5000);
		if (eventNumber==14) kabu.���i���̊����ϓ�(10000);
		if (eventNumber==15) kabu.���i���̊����ϓ�(5000);
		if (eventNumber==16) {
			kabu.��c���̊����ϓ�(-3000);
			kabu.�������̊����ϓ�(-3000);
			kabu.�E�`�N�����̊����ϓ�(5000);
			kabu.���i���̊����ϓ�(5000);
		}if (eventNumber==17) {
			kabu.��c���̊����ϓ�(-5000);
			kabu.�������̊����ϓ�(-5000);
		}
		if (eventNumber==18) {
			kabu.�������̊����ϓ�(5000);
			kabu.�E�`�N�����̊����ϓ�(5000);
		}if (eventNumber==19) {
			kabu.��c���̊����ϓ�(10000);
			kabu.�������̊����ϓ�(10000);
			kabu.�E�`�N�����̊����ϓ�(10000);
			kabu.���i���̊����ϓ�(10000);
		}if (eventNumber==20) {
			kabu.��c���̊����ϓ�(5000);
			kabu.�������̊����ϓ�(5000);
		}if (eventNumber==21) kabu.�E�`�N�����̊����ϓ�(-3000);
		if (eventNumber==22) kabu.��c���̊����ϓ�(5000);
		if (eventNumber==23) kabu.���i���̊����ϓ�(2000);
		if (eventNumber==24) kabu.���i���̊����ϓ�(1000);
	}
}