package org.recast4j.detour.extras;

import org.recast4j.detour.MeshData;
import org.recast4j.detour.Poly;

public class PolyUtils {

	/** 
	 * Find edge shared by 2 polygons within the same tile
	 */
	public static int findEdge(Poly node, Poly neighbour, MeshData tile, MeshData neighbourTile) {
		// Compare indices first assuming there are no duplicate vertices
		for (int i = 0; i < node.vertCount; i++) {
			int j = (i + 1) % node.vertCount;
			for (int k = 0; k < neighbour.vertCount; k++) {
				int l = (k + 1) % neighbour.vertCount;
				if ((node.verts[i] == neighbour.verts[l] && node.verts[j] == neighbour.verts[k])
						|| (node.verts[i] == neighbour.verts[k] && node.verts[j] == neighbour.verts[l])) {
					return i;
				}
			}
		}
		// Fall back to comparing actual positions in case of duplicate vertices
		for (int i = 0; i < node.vertCount; i++) {
			int j = (i + 1) % node.vertCount;
			for (int k = 0; k < neighbour.vertCount; k++) {
				int l = (k + 1) % neighbour.vertCount;
				if ((samePosition(tile.verts, node.verts[i], neighbourTile.verts, neighbour.verts[l])
						&& samePosition(tile.verts, node.verts[j], neighbourTile.verts, neighbour.verts[k]))
						|| (samePosition(tile.verts, node.verts[i], neighbourTile.verts, neighbour.verts[k])
								&& samePosition(tile.verts, node.verts[j], neighbourTile.verts, neighbour.verts[l]))) {
					return i;
				}
			}
		}
		return -1;
	}

	private static boolean samePosition(float[] verts, int v, float[] verts2, int v2) {
		for (int i = 0; i < 3; i++) {
			if (verts[3 * v + i] != verts2[3 * v2 + 1]) {
				return false;
			}
		}
		return true;
	}
	
	/** 
	 * Find edge closest to the given coordinate
	 */
	public static int findEdge(Poly node, MeshData tile, float value, int comp) {
		float error = Float.MAX_VALUE;
		int edge = 0;
		for (int i = 0; i < node.vertCount; i++) {
			int j = (i + 1) % node.vertCount;
			float v1 = tile.verts[3 * node.verts[i] + comp] - value;
			float v2 = tile.verts[3 * node.verts[j] + comp] - value;
			float d = v1 * v1 + v2 * v2;
			if (d < error) {
				error = d;
				edge = i;
			}
		}
		return edge;
	}
}