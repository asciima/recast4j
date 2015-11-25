package org.recast4j.detour.crowd;

import org.junit.Test;

public class CrowdTest extends AbstractCrowdTest {

	static final float[] EXPECTED_POS1 = {
	22.606520f, 10.197294f, -45.918674f,
	22.322426f, 10.197294f, -45.771397f,
	21.754303f, 10.197294f, -45.476715f,
	21.133097f, 10.197294f, -45.154068f,
	20.512094f, 10.197294f, -44.831028f,
	19.891315f, 10.197294f, -44.507557f,
	19.270782f, 10.197294f, -44.183617f,
	18.650520f, 10.197294f, -43.859158f,
	18.030558f, 10.197294f, -43.534126f,
	17.410927f, 10.197294f, -43.208462f,
	16.791668f, 10.197294f, -42.882092f,
	16.172823f, 10.197294f, -42.554935f,
	15.554445f, 10.197294f, -42.226898f,
	14.936594f, 10.197294f, -41.897869f,
	14.319340f, 10.197294f, -41.567722f,
	13.702767f, 10.197294f, -41.236305f,
	13.086977f, 10.197294f, -40.903435f,
	12.472089f, 10.197294f, -40.568901f,
	11.858250f, 10.197294f, -40.232449f,
	11.245640f, 10.197294f, -39.893761f,
	10.634483f, 10.197294f, -39.552460f,
	10.025061f, 10.197294f, -39.208069f,
	9.417730f, 10.197294f, -38.860004f,
	8.812954f, 10.197294f, -38.507519f,
	8.211343f, 10.197294f, -38.149658f,
	7.613717f, 10.197294f, -37.785183f,
	7.021209f, 10.197294f, -37.412445f,
	6.435429f, 10.197294f, -37.029221f,
	5.858753f, 10.197294f, -36.632427f,
	5.294861f, 10.197294f, -36.217667f,
	4.749827f, 10.197294f, -35.778419f,
	4.234636f, 10.197294f, -35.304523f,
	3.772264f, 10.197294f, -34.778965f,
	3.428036f, 10.197294f, -34.169453f,
	3.033963f, 10.197294f, -33.590916f,
	2.656040f, 10.197294f, -33.001701f,
	2.307335f, 10.197294f, -32.394737f,
	2.021275f, 10.197294f, -31.755856f,
	1.935164f, 10.197294f, -31.061172f,
	1.847493f, 10.197294f, -30.366684f,
	1.943488f, 10.197294f, -29.673298f,
	2.170555f, 10.197294f, -29.011150f,
	2.415170f, 10.197294f, -28.355282f,
	2.677041f, 10.197294f, -27.706110f,
	2.938912f, 10.197294f, -27.056938f,
	3.200784f, 10.197294f, -26.407766f,
	3.462655f, 10.197294f, -25.758595f,
	3.724526f, 10.197294f, -25.109423f,
	3.986398f, 10.197294f, -24.460251f,
	4.248269f, 10.197294f, -23.811079f,
	4.510140f, 10.197294f, -23.161907f,
	4.772012f, 10.197294f, -22.512735f,
	5.033883f, 10.197294f, -21.863564f,
	5.295755f, 10.197294f, -21.214392f,
	5.557627f, 10.197294f, -20.565220f,
	5.819499f, 10.197294f, -19.916048f,
	6.081370f, 10.197294f, -19.266876f,
	6.297070f, 10.197294f, -18.723810f,
	6.397289f, 10.197294f, -18.479179f,
	6.439916f, 10.197294f, -18.384853f,
	6.454712f, 10.197294f, -18.342505f};
	
	@Test
	public void test1() {
		int updateFlags = CrowdAgent.DT_CROWD_ANTICIPATE_TURNS | CrowdAgent.DT_CROWD_OPTIMIZE_VIS
				| CrowdAgent.DT_CROWD_OPTIMIZE_TOPO | CrowdAgent.DT_CROWD_OBSTACLE_AVOIDANCE;

		addAgentGrid(1, 0.4f, updateFlags, startPoss[0]);
		for (CrowdAgent ag : crowd.getActiveAgents()) {
			crowd.requestMoveTarget(ag.getAgentIndex(), endRefs[0], endPoss[0]);
		}
		for (int i = 0; i < EXPECTED_POS1.length / 3; i++) {
			dumpActiveAgents();
			crowd.update(1/5f, null);
		}
		dumpActiveAgents();
		// crowd.addAgent(startPoss[0], ap);
	}

	private void dumpActiveAgents() {
		System.out.println(crowd.getActiveAgents().size());
		for (CrowdAgent ag : crowd.getActiveAgents()) {
			System.out.println(ag.state + ", " + ag.targetState);
			System.out.println(ag.npos[0] + ", " + ag.npos[1] + ", " + ag.npos[2]);
			System.out.println(ag.nvel[0] + ", " + ag.nvel[1] + ", " + ag.nvel[2]);
		}
	}

}


//GetPolyHeight: 281474976710696, 22.606520,10.197294,-45.918674
//GetPolyHeight: 281474976710695, 22.322426,10.197294,-45.771397
